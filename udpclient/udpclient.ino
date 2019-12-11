
#include <ESP8266WiFi.h>
#include <WiFiUdp.h>

WiFiUDP Client;


byte serdata=0;
byte fromserver=0;


WiFiUDP Udp;
unsigned int localUdpPort = 1234;  // local port to listen on
char incomingPacket[255];  

void setup() 
{
  // put your setup code here, to run once:
  Serial.begin(9600);
  WiFi.mode(WIFI_STA); 
  WiFi.begin("SecureIoT","secureiot123");
  Serial.println();
    Serial.println();
    Serial.print("Wait for WiFi... ");
    
  while(WiFi.status() != WL_CONNECTED) 
  {
    Serial.print(".");
        delay(500);
  }
     Serial.println("");
    Serial.println("WiFi connected");
    Serial.println("IP address: ");
    Serial.println(WiFi.localIP());   
    Client.begin(81);
    Udp.begin(localUdpPort);
  Serial.printf("Now listening at IP %s, UDP port %d\n", WiFi.localIP().toString().c_str(), localUdpPort);
}


void udpsend()
  {
    const char ip[]="192.168.31.66";
  Client.beginPacket(ip,1234);
  String reply = "";
  int temp = analogRead(0);
   temp = temp * 0.48828125;
    reply = ("B1104B N1 - ".concat(digitalRead(7))).concat(" 1 ").concat(temp);
    char res [50];
    reply.toCharArray(res, 50);
  Client.write(res);
  Client.endPacket();
  //delay(10000);
  return;
  }

void lock()
{
   switchOff();
}

void unlock()
{
  
}

void powerOn()
{
  
}

void switchOff()
{
  
}

void loop() 
{
    const int port=1234;
    int i=0;  
    udpsend();
    int packetSize = Udp.parsePacket();
    if (packetSize)
    {
    // receive incoming UDP packets
    Serial.printf("Received %d bytes from %s, port %d\n", packetSize, Udp.remoteIP().toString().c_str(), Udp.remotePort());
    int len = Udp.read(incomingPacket, 255);
    if (len > 0)
    {
      incomingPacket[len] = 0;
    }
    Serial.printf("UDP packet contents: %s\n", incomingPacket);
    switch(incomingPacket[0])
    {
      case 'L':lock();
               break;
      case 'U':unlock();
               break;
      case 'P':powerOn();
               break;
      case 'S':switchOff();
               break;         
    }
    }

}

