"""""
import random

x = random.randint(100,1000)

cuadrado = list(map(lambda x: random.randint(5000,10000),range(100)))
print("lista de numeros ramdom: ");

print(cuadrado);

seleccion = list(map(lambda x: random.randint(0,99),range(1)))
print("campo seleccionado: ")
print(seleccion)

print("Elemento del campo: ")
print(cuadrado[seleccion[0]])
"""

import random


listaMontoDinero = []

escogerCampoSeleccionado = []


montoSeleccionado = 0

listaPrincipal=[]

class PC:
    def __init__(self,numeroSerie,nombre,RAM,precio,CPU):

        self.serie = numeroSerie
        self.modelo = nombre
        self.RAM =RAM
        self.precio = precio
        self.CPU = CPU

    def agregar(self,objetoPC):
        global listaPrincipal
        listaPrincipal.append(objetoPC)

    def getSerie(self):
        return self.serie

    def getModelo(self):
        return  self.modelo

    def getRAM(self):
        return self.RAM

    def getPrecio(self):
        return self.precio

    def getCPU(self):
        return self.CPU

    def setSerie(self,nueva):
        self.serie = nueva

    def setModelo(self,nueva):
        self.modelo=nueva

    def setRAM(self,nueva):
        self.RAM=nueva

    def setPrecio(self,nueva):
        self.precio= nueva

    def setCPU(self,nueva):
        self.CPU=nueva



class Portatil:
    def __init__(self,numeroSerie,nombre,RAM,precio,CPU):

        self.serie = numeroSerie
        self.modelo = nombre
        self.RAM =RAM
        self.precio = precio
        self.CPU = CPU

    def agregar(self,objetoPC):
        global listaPrincipal
        listaPrincipal.append(objetoPC)

    def getSerie(self):
        return self.serie

    def getModelo(self):
        return  self.modelo

    def getRAM(self):
        return self.RAM

    def getPrecio(self):
        return self.precio

    def getCPU(self):
        return self.CPU

    def setSerie(self,nueva):
        self.serie = nueva

    def setModelo(self,nueva):
        self.modelo=nueva

    def setRAM(self,nueva):
        self.RAM=nueva

    def setPrecio(self,nueva):
        self.precio= nueva

    def setCPU(self,nueva):
        self.CPU=nueva

def agregar():

    tipo = input("1.Crear Portaril\n2.Crear PC\nOpcion: ")
    serie = input("\nDigite la serie: ")
    modelo = input("Digite el modelo: ")
    ram =input("Digite la ram: ")
    precio = input("Digite el precio: ")
    cpu = input("Digite la cpu: ")
    if(tipo == "1"):
        objetoPortail = Portatil(serie,modelo,ram,precio,cpu)
        objetoPortail.agregar(objetoPortail)
    elif(tipo == "2"):
        objetoPC = PC(serie,modelo,ram,precio,cpu)
        objetoPC.agregar(objetoPC)


def lista():
    global listaPrincipal
    print("largo "+str(len(listaPrincipal)))
    x= 0
    while x < len(listaPrincipal):
        print(listaPrincipal[x].getCPU())
        x=x+1

def eliminar():
    global listaPrincipal
    idEliminar = input("Digite el numero de serie del objeto a eliminar:  ")
    print("idELiminar: " + idEliminar)
    print("\nlista sin eliminar: \n")
    lista()
    loEncontro = list(filter(lambda x: x.getSerie() == idEliminar ,listaPrincipal))
    listaElementosNueva = list(filter(lambda x: x.getSerie() !=idEliminar,listaPrincipal))
    listaPrincipal = listaElementosNueva
    if(len(loEncontro)!=0):
        print("\neliminado\n")
    else:
        print("no se encontro el numero de serie")

def modificar():
    global listaPrincipal
    idModificar = input("Digite el id por eliminar: ")
    loEncontro = False
    x=0
    while x < len(listaPrincipal):
        if(listaPrincipal[x].getSerie() == idModificar):
            loEncontro = True
            print("\n\nSerie: " + str(listaPrincipal[x].getSerie()))
            print("modelo: " + str(listaPrincipal[x].getModelo()))
            print("RAM: " + str(listaPrincipal[x].getRAM()))
            print("precio: " + str(listaPrincipal[x].getPrecio()))
            print("CPU: " + str(listaPrincipal[x].getCPU()))
            break
        else:
            x = x+1

    if(loEncontro==True):
        print("Digite los nuevos datos")

        serie = input("\nDigite la serie: ")
        modelo = input("Digite el modelo: ")
        ram =input("Digite la ram: ")
        precio = input("Digite el precio: ")
        cpu = input("Digite la cpu: ")

        x=0
        while x < len(listaPrincipal):
            if(listaPrincipal[x].getSerie() == idModificar):
                listaPrincipal[x].setSerie(serie)
                listaPrincipal[x].setModelo(modelo)
                listaPrincipal[x].setRAM(ram)
                listaPrincipal[x].setPrecio(precio)
                listaPrincipal[x].setCPU(cpu)
                break
    else:
        print("no se encontro el dato")




def generardor():
    global listaPrincipal
    x = 0
    while x < len(listaPrincipal):
        print("\n\nSerie: " + str(listaPrincipal[x].getSerie()))
        print("modelo: " + str(listaPrincipal[x].getModelo()))
        print("RAM: " + str(listaPrincipal[x].getRAM()))
        print("precio: " + str(listaPrincipal[x].getPrecio()))
        print("CPU: " + str(listaPrincipal[x].getCPU()))
        yield x
        x = x + 1

def listaGeneradores():

    global listaPrincipal
    i=generardor()
    while(True):
        try:
            i.__next__()
        except StopIteration:
            print("\nFIN\n")
            break
        opcion = input("1.Mostrar siguiente registro\n2.No continuar\nOpcion: ")
        if(opcion=="2"):
            break

def listaSePuedeComprar():
    global listaPrincipal
    global montoSeleccionado
    listaComprar = list(filter(lambda x: x.getPrecio()<=montoSeleccionado ,listaPrincipal))

    x=0
    while x<len(listaComprar):
        print("\n\nSerie: " + str(listaPrincipal[x].getSerie()))
        print("modelo: " + str(listaPrincipal[x].getModelo()))
        print("RAM: " + str(listaPrincipal[x].getRAM()))
        print("precio: " + str(listaPrincipal[x].getPrecio()))
        print("CPU: " + str(listaPrincipal[x].getCPU()))
        x=x+1



total = 0
def comprar():
    global total
    global listaPrincipal
    compro = False
    while(True):
        listaSePuedeComprar()
        id = input("\nDigite el numero de serie del producto a comprar: ")


        x = 0
        while x < len(listaPrincipal):
            if(listaPrincipal[x].getSerie() == id):
                total=total+listaPrincipal[x].getPrecio()
                compro = True
                break
            x = x + 1
        if(compro==False):
            print("\nDato no encontrado")
        elif(compro==True):
            compro=False
            opcion = input("1.Desea comprar otro producto\n2.No deseo comprar mas")
            if(opcion == "2"):
                print("\n\nTotal Compra: " , total)
                break
def menu():
    print("\n\n1.Agregar\n2.Eliminar\n3.Modificar\n4.Listar todos los productos con generadores\n5.Listar productos accesibles a compra con lambda\n6.Comprar\n7.Salir\nOpcion: ")
    opcion = input()
    if(opcion=="1"):
        agregar()
        menu()
    elif(opcion =="2"):
        eliminar()
        menu()
    elif(opcion=="3"):
        modificar()
        menu()
    elif(opcion=="4"):
        listaGeneradores()
        menu()
    elif(opcion=="5"):
        listaSePuedeComprar()
        menu()
    elif(opcion=="6"):
        comprar()
        menu()
    elif(opcion=="7"):
        exit(0)
    lista()
    menu()

def main():
    global listaPrincipal
    global listaMontoDinero
    global escogerCampoSeleccionado
    global montoSeleccionado

    listaMontoDinero = list(map(lambda x: random.randint(5000, 10000), range(100)))
    escogerCampoSeleccionado = list(map(lambda x: random.randint(0, 99), range(1)))
    montoSeleccionado = listaMontoDinero[escogerCampoSeleccionado[0]]


    objetoPC1 = PC("a", "a", "a", 1000, "a")
    objetoPC1.agregar(objetoPC1)

    objetoPC2 = PC("b", "b","b" , 500, "b")
    objetoPC2.agregar(objetoPC2)


    objetoPorta = PC("c", "c","c" , 50000, "c")
    objetoPorta.agregar(objetoPorta)

    menu()

main()