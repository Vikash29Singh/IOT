
//LCD   Ard-UNO
//pin 1 to gnd
//pin 2 5v
//pin 3 6
//pin 4 12
//pin 5 gnd
//pin 6 11
//pin 11 5
//pin 12 4
//pin 13 3
//pin 14 2
//pin 15 5v
//pin 16 gnd


void setup()
{
  pinMode(SCK, OUTPUT);
  pinMode(sw, INPUT_PULLUP);
  analogWrite(6, Contrast);
  lcd.begin(16, 2);
  lcd.print(" Weight ");
  lcd.setCursor(0, 1);
  lcd.print(" Measurement ");
  delay(1000);
  lcd.clear();
  calibrate();
}

void loop()
{
  count = readCount();
  lcd.setCursor(0, 0);
  lcd.print("Please Wait");
  lcd.setCursor(0, 1);
  lcd.print(w);
  lcd.print("g ");
}
