#include <ESP8266WiFi.h>
#include <SPI.h>
 
#include <WiFiClient.h>
 
#include <ThingSpeak.h>

#define SUCCESS_PIN D3  //green led - data to server
#define CONN_PIN D4     //yellow - wifi connection

 
const char* ssid = "Hack it if you can"; //Your Network SSID
 
const char* password = "12345678"; //Your Network Password
 
int val;
 
int LDRpin = A0; //LDR Pin Connected at A0 Pin
 
 
 
WiFiClient client;
 
unsigned long myChannelNumber = 966258;//Your Channel Number (Without Brackets)
 
const char * myWriteAPIKey = "21IVIOQC7ISDBOVK"; //Your Write API Key
 
void setup()
 
{
 
Serial.begin(9600);
SPI.begin();      //--> Init SPI bus
delay(10);
 
// Connect to WiFi network
 
WiFi.begin(ssid, password);
 
 //pinMode(ON_Board_LED,OUTPUT); 
  pinMode(CONN_PIN, OUTPUT);
   pinMode(SUCCESS_PIN, OUTPUT);
  Serial.print("Connecting");    
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    //----------------------------------------Make the On Board Flashing LED on the process of connecting to the wifi router.
    digitalWrite(CONN_PIN, LOW);
    delay(250);
    digitalWrite(CONN_PIN, HIGH);
    delay(250);
  }

  digitalWrite(CONN_PIN, LOW); //--> Turn off the On Board LED when it is connected to the wifi router.
  digitalWrite(SUCCESS_PIN, HIGH);
  //----------------------------------------If successfully connected to the wifi router, the IP Address that will be visited is displayed in the serial monitor
  Serial.println("");
  Serial.print("Successfully connected to : ");
  Serial.println(ssid);
  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());
  
ThingSpeak.begin(client);
 
}
 
 
 
void loop()
 
{
 
val = analogRead(LDRpin); //Read Analog values and Store in val variable
 
Serial.print(val); //Print on Serial Monitor
 
delay(1000);
 
ThingSpeak.writeField(myChannelNumber, 1,val, myWriteAPIKey); //Update in ThingSpeak
 
 
 
delay(100);
 
}
