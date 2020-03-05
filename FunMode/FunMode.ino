bool inFunMode = false;

// Potentiometers
int  valPot1 = 0;
int  valPot2 = 0;
const byte pinPot1 = A1;
const byte pinPot2 = A2;

// Button
byte btnPin   = A0;
int  btnState = 0;

// BarGraph pins
const byte numOfGraphLeds = 10;
const byte bargraph[] = {2,3,4,5,6,7,8,A4,A5,12};

// RGB Diode
const byte rgb[] = {9,10,11};

void setup() {
    //Pinmode
    pinMode(pinPot1, INPUT);
    pinMode(pinPot2, INPUT);
    
    for(int i=0; i<numOfGraphLeds; i++){
        pinMode(bargraph[i], OUTPUT);
    }

    Serial.begin(9600);
}

void loop() {
    if(!inFunMode){
        readInput();
        setBarGraph();
        setRGB();
    }else{
        makeFun();
    }
}

void setBarGraph() {

    byte counter = 0;
    byte barState = map(constrain(valPot1, 0, 1023), 0, 1023, 0, 10);
    
    while(counter < numOfGraphLeds){
        if(barState >= counter+1){
            digitalWrite(bargraph[counter], HIGH);
        }else{
            digitalWrite(bargraph[counter], LOW);
        }
        
        counter++;
    }
}

void readInput() {
    valPot1  = analogRead(pinPot1);
    valPot2  = analogRead(pinPot2);
    btnState = analogRead(btnPin);

    Serial.println(btnState);

    if(btnState > 500){
        inFunMode = true;
    }
}

void setRGB() {
    int potState = map(constrain(valPot2, 0, 1023), 0, 1023, 0, 765);

    if(potState > 0 && potState <= 255){
        byte red = map(potState, 1, 255, 1, 255);
        writeRGBState(red, 0, 0);
    }else if(potState > 255 && potState <= 510){
        byte green = map(potState, 256, 510, 1, 255);
        writeRGBState(0, green, 0);
    }else if(potState > 510){
        byte blue = map(potState, 511, 765, 1, 255);
        writeRGBState(0, 0, blue);
    }else{
        writeRGBState(0, 0, 0);
    }
}

void writeRGBState(byte r, byte g, byte b){
    analogWrite(rgb[0], r);
    analogWrite(rgb[1], g);
    analogWrite(rgb[2], b);
}

void makeFun(){

    int counter = 0;
    int cycle  = 0;
    int cycles = 4;

    while(counter < numOfGraphLeds){
        digitalWrite(bargraph[counter], LOW);
        counter++;
    }

    while(cycle < cycles){
        counter = 0;
        
        while(counter < numOfGraphLeds){
            if(counter < numOfGraphLeds){
                digitalWrite(bargraph[counter], HIGH);
            }else{
                digitalWrite(bargraph[counter], LOW);
            }
            
            counter++;
            delay(50);
        }

        while(counter > 0){
            if(counter-1 > numOfGraphLeds){
                digitalWrite(bargraph[counter], HIGH);
            }else{
                digitalWrite(bargraph[counter], LOW);
            }
            counter--;
            delay(50);
        }

        cycle++;
    }

    inFunMode = false;
}
