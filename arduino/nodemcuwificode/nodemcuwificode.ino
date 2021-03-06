/*
    This sketch establishes a TCP connection to a "quote of the day" service.
    It sends a "hello" message, and then prints received data.
*/

#include <ESP8266WiFi.h>
#include <SPI.h>
//
//#ifndef STASSID
//#define STASSID "your-ssid"
//#define STAPSK  "your-password"
//#endif

const char* ssid     = "IOT";
const char* password = "Apnasapnamoney2";
static const uint8_t D3   = 0;
static const uint8_t D4   = 2;
#define SUCCESS_PIN D3  //green led - data to server
#define CONN_PIN D4     //yellow - wifi connection

void setup() {
  // put your setup code here, to run once:


Serial.begin(9600); //--> Initialize serial communications with the PC
  SPI.begin();      //--> Init SPI bus

  delay(500);

  WiFi.begin(ssid, password); //--> Connect to your WiFi router
  Serial.println("");
    
  //pinMode(ON_Board_LED,OUTPUT); 
  pinMode(CONN_PIN, OUTPUT);
   pinMode(SUCCESS_PIN, OUTPUT);
   
  
  //digitalWrite(ON_Board_LED, HIGH); //--> Turn off Led On Board

  //----------------------------------------Wait for connection
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
  
}

void loop() {
  // put your main code here, to run repeatedly:

}
