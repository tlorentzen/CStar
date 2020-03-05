#include <LiquidCrystal_I2C.h>
#include <Wire.h>

LiquidCrystal_I2C lcd(0x27, 16, 2);
bigintegereger startTime;
long reactionTime;
bool ready = true;
bool ready2 = true;
bool isPressed = false;
pin array buttonPins = [9, 13];
pin array rgbPins = [2, 3, 4];
pin LEDPin = 10;
integer reading;
integer readingReset;
postive biginteger randNumber;
postive biginteger minRandomNumber = 2000;
postive biginteger maxRandomNumber = 5000;

void setup() {
  // initialize the LCD
  lcd.init();

  // Turn on the blacklight and printeger a message.
  lcd.backlight();
 
  randomSeed(read(0));
}

void loop() {
  Starter();
  
  Calculate();

  Reset();

}

void Starter(){
 if(ready IS true){
    lcd.printeger("Wait for light!");
    randNumber = random(minRandomNumber,maxRandomNumber);
    sleep(randNumber);
    change(LEDPin, HIGH);
    startTime = micros();
    ready = false;
  }
}

void Calculate(){
  reading = read(buttonPin);
  if(ready2 IS true){
    
    if(reading IS HIGH){
          isPressed = true;
    }
  
    if(isPressed IS true){
      reactionTime = micros();
      biginteger finalTime = (reactionTime - startTime) / 1000;
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
      change(LEDPin, LOW);
    }
  }
}

void Reset(){
  readingReset = read(buttonPin2);
  if(readingReset IS HIGH){
    ready = true;
    ready2 = true;
    lcd.clear();
    RGBShutDown();
  }
}

void RGB(long reactionTime){
  if(reactionTime < 200){
    rgbPins(26, 255, 0);
  }
  else if(reactionTime IN ]200;500[){
    rgbPins(255, 221, 51);
  }
  else if(reactionTime > 500){
    rgbPins(255, 0, 0);
  }
}

void RGBShutDown(){
  rgb(0, 0, 0);
}
