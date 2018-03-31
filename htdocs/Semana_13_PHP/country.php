<?php



    Class Continent{
        public $name;
        function __construct($name){
            $this->name = $name;
        }
    }


    Class Country extends Continent{
        public $id;
        public $name;
        public $points;
        public $confederation;
        private $active;

        function __construct($id,$name,$points,$confederation,$active,$continent){
            parent::__construct($continent);
            $this->id = $id;
            $this->name = $name;
            $this->points = $points;
            $this->confederation = $confederation;
            $this->active = $active;
        }
        function get_active(){ //para poder acceder a variables privadas
            return $this->active;
        }
        function set_confederation($confederation){
            $this->confederation = $confederation;
        }
    }

    $alemania = new Country(1,'Alemania',1690,'UEFA',true,'Europe');
    echo $alemania->points. "<br>"; //GET VALUE WITHOUT GET METHOD
    print_r($alemania); //IMPRIME TODO EL OBJETO
    echo "<br>" . $alemania->get_active() . "<br>"; //GET METHOD
    $alemania->set_confederation('CONCACAF'); //SET METHOD
    print_r($alemania);
    echo "<br>". get_class($alemania) . "<br>"; //OBTIENE LA CLASE DEL OBJETO
    echo get_parent_class($alemania);


    $costaRica = new Country(2,'Costa Rica',990,'CONCACAF',true,'America');


    $countries = array($alemania);
    echo "<h1>Lista paises</h1>";
    print_r($countries);


    array_push($countries,$costaRica);
    echo "<h1>Lista paises</h1>";
    print_r($countries);
    echo "<br>";
    print_r($countries[1]->name);  

?>