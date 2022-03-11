# Wallmart
Prueba Full Stack Developer Palíndromo

#Pasos para poder compilar la aplicación
#Paso 1

#Correr el comando mvn clean package -DskipTest
#Para poder crear el .jar de aplicación
#Dentro la ruta de wallmart-api
#Considerar open-jdk-17 que corre la aplicación

#Paso 2
#Ejecutar el comando si esta en linux
#En la ruta raíz del proyecto el archivo llamado Makefile
#sudo make run
#Si no cuenta con con el comando make, ejecutar el siguiente comando
#sudo apt install make

#Si esta en windows
#En la ruta raíz del proyecto el archivo llamado Makefile.win
#nmake -f makefile.win

#Si no funciona el archivo Makefile por alguna razón, ejecutar los siguientes comandos
#docker build -t wallmart-api:0.0.1 wallmart-api/
#docker build -t wallmart-ui:0.0.1 wallmart-ui/
#docker-compose up --build
#Para crear las imagenes docker y luego generar el contenedor

#Esto levantará la aplicacion corriendo nginx en el puerto 80 con angular
#http://localhost:80
#El servicio de spring boot se levanta en el puerto 8030
#Base de datos Mongodb se levanta en el puerto 27017 que viene por defecto

#Para probar el servicio directamente existe un archivo llamado thunder-collection_Wallmart.json
#Que esta dentro del directorio raíz
#Para poder usar el cliente thunder, desde vscode buscar "thunder" en las extensiones y aparecerá de los primeros e instalar
#Luego se de importar el archivo
#Solo tiene 1 solo endpoint de tipo GET el cual es capaz de discriminar por ID para busqueda directa
#De lo contrario reliazará una busqueda más amplía, además de aplicar el descuento de un 50% cuando sea un palíndromo