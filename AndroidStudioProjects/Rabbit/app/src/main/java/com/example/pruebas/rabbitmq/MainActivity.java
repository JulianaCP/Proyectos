package com.example.pruebas.rabbitmq;

import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.Console;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       // String message = "hola222";
       // new send().execute(message);





        publishToAMQP();


    }
    Thread subscribeThread;
    Thread publishThread;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        publishThread.interrupt();
        subscribeThread.interrupt();
    }

    public void publishToAMQP()
    {
        System.out.println("entro");
        publishThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
                try {
                    ConnectionFactory factory = new ConnectionFactory();
                    factory.setUsername("guest");
                    factory.setPassword("guest");
                    factory.setHost("172.24.46.116");
                    factory.setPort(5672);
                    System.out.println("a");

                    try{
                        System.out.println("a.1");
                        Connection connection = factory.newConnection();
                        System.out.println("a.2");
                        Channel channel = connection.createChannel();
                        System.out.println("b");
                        channel.confirmSelect();
                        System.out.println("c");

                        channel.exchangeDeclare("sample-ex", "direct", true, false, null);
                        String queueName = channel.queueDeclare().getQueue();
                        System.out.println("d");
                        channel.queueDeclare(queueName, true, false, false, null);
                        channel.queueBind(queueName, "logs", "");
                        channel.basicQos(0, 1, false);
                        System.out.println("4");
                        String message = "Hola";
                        channel.basicPublish("amq.fanout", "chat", null, message.getBytes());
                    }catch (Exception e) {
                        System.out.println("error: " + e);
                    }
                }  catch (Exception e) {
                    Log.d("", "Connection broken: " + e.getClass().getName());
                }
            }
        });
        publishThread.start();
    }

    private String EXCHANGE_NAME = "test";
    private class send extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... Message) {
            try {

                ConnectionFactory factory = new ConnectionFactory();
                factory.setHost("172.24.46.116");

                // my internet connection is a bit restrictive so I have use an
                // external server
                // which has RabbitMQ installed on it. So I use "setUsername"
                // and "setPassword"

                factory.setUsername("guest");
                factory.setPassword("guest");
                //factory.setVirtualHost("karthi");
                factory.setPort(5672);
                System.out.println(""+factory.getHost()+factory.getPort()+factory.getRequestedHeartbeat()+factory.getUsername());
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel();
                String QUEUE_NAME = channel.queueDeclare().getQueue();
                channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);
                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                channel.basicQos(0, 1, false);
                String tempstr = "hola";
                for (int i = 0; i < Message.length; i++)
                    tempstr += Message[i];

                channel.basicPublish(EXCHANGE_NAME, QUEUE_NAME, null,
                        tempstr.getBytes());

                channel.close();

                connection.close();

            } catch (Exception e) {
                System.out.println("errorrrrr: "  + e);
                // TODO: handle exception
                e.printStackTrace();
            }
            // TODO Auto-generated method stub
            return null;
        }

    }


}
