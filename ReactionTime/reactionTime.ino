#include <LiquidCrystal_I2C.h>
#include <Wire.h> 

LiquidCrystal_I2C lcd(0x27, 16, 2);
long startTime;
long reactionTime;
bool ready = true;
bool ready2 = true;
bool isPressed = false;
const int buttonPin = 9;
const int buttonPin2 = 13;
const int LEDPin = 10;
const int blueLED = 2;
const int greenLED = 3;
const int redLED = 4;
int buttonState;
int reading;
int readingReset;
unsigned long randNumber;
unsigned long minRandomNumber = 2000;
unsigned long maxRandomNumber = 5000;

void setup() {
  pinMode(buttonPin, INPUT);
  pinMode(LEDPin, OUTPUT);
  pinMode(blueLED, OUTPUT);
  pinMode(greenLED, OUTPUT);
  pinMode(redLED, OUTPUT);
  // initialize the LCD
  lcd.init();

  // Turn on the blacklight and print a message.
  lcd.backlight();
  
  
  randomSeed(analogRead(0));
}

// the loop function runs over and over again forever
void loop() {
 Starter();
  
 Calculate();

 Reset();

}

void Starter(){
 if(ready == true){
    lcd.print("Wait for light!");
    randNumber = random(minRandomNumber,maxRandomNumber);
    delay(randNumber);
    digitalWrite(LEDPin, HIGH);
    startTime = micros();
    ready = false;
  }
}

void Calculate(){
  reading = digitalRead(buttonPin);
  if(ready2 == true){
    
    if(reading == HIGH){
    isPressed = true; 
    }
  
    if(isPressed == true){
      reactionTime = micros();
      long finalTime = (reactionTime - startTime) / 1000;
      //finalTime /= 1000;
      lcd.clear();
      lcd.print("Reaction time:");
      lcd.setCursor(0, 1);// 1 kolonne, 2 raekke
      lcd.print(finalTime);
      lcd.print("ms");
      RGB(finalTime);
      ready = false;
      isPressed = false;
      ready2 = false;
      digitalWrite(LEDPin, LOW);
    }
  }
}

void Reset(){
  readingReset = digitalRead(buttonPin2);
 if(readingReset == HIGH){
  ready = true;
  ready2 = true;
  lcd.clear();
  RGBShutDown();
 }
}

void RGB(long reactionTime){
  if(reactionTime < 200){
    digitalWrite(redLED, 26);
    digitalWrite(greenLED, 255);
    digitalWrite(blueLED, 0);
  }
  else if(reactionTime < 500 && reactionTime > 200){
    digitalWrite(redLED, 255);
    digitalWrite(greenLED, 221);
    digitalWrite(blueLED, 51);
  }
  else if(reactionTime > 500){
    digitalWrite(redLED, 255);
    digitalWrite(greenLED, 0);
    digitalWrite(blueLED, 0);
  }
}

void RGBShutDown(){
  digitalWrite(redLED, 0);
  digitalWrite(greenLED, 0);
  digitalWrite(blueLED, 0);
}
