int inFunMode = 0;
int valPot1 = 0;
int valPot2 = 0;
int pinPot1 = A1;
pinMode(pinPot1, OUTPUT);
int pinPot2 = A2;
pinMode(pinPot2, OUTPUT);
int btnPin = A0;
pinMode(btnPin, OUTPUT);
int btnState = 0;
int numOfGraphLeds = 10;
int bargraph[] = {2, 3, 4, 5, 6, 7, 8, A4, A5, 12};
int rgb[] = {9, 10, 11};
void setup(){

}
void loop(){
    if(inFunMode == 0){
    readInput();
    setBarGraph();
    setRGB();

}
else{
    makeFun();

}

}
void setBarGraph(){
    int counter = 0;
    int barState = map(constrain(valPot1, 0, 1023);
, 0, 1023, 0, 10);
;
    while(counter < numOfGraphLeds){
    int bg = bargraph[counter];
    if(barState > counter + 1 && barState == counter + 1){
    bg = 255;

}
else{
    bg = 0;

}
    counter = counter + 1;

}

}
void readInput(){
    valPot1 = pinPot1;
    valPot2 = pinPot2;
    btnState = btnPin;
    console.println(btnState);
    if(btnState > 500){
    inFunMode = 1;

}

}
void setRGB(){
    int potState = map(constrain(valPot2, 0, 1023);
, 0, 1023, 0, 765);
;
    if(potState == 1 || potState > 1 && potState < 255 || potState == 255){
    int red = map(potState, 1, 255, 1, 255);
;
    writeRGBState(red, 0, 0);

}
    if(potState == 256 || potState > 256 && potState < 510 || potState == 510){
    int green = map(potState, 256, 510, 1, 255);
;
    writeRGBState(0, green, 0);

}
    if(potState > 510){
    int blue = map(potState, 511, 765, 1, 255);
;
    writeRGBState(0, 0, blue);

}

}
void writeRGBState(ArduinoC r, ArduinoC g, ArduinoC b){
    rgb[0] = r;
    rgb[1] = g;
    rgb[2] = b;

}
void makeFun(){
    int counter = 0;
    int cycle = 0;
    int cycles = 4;
    while(counter < numOfGraphLeds){
    bargraph[counter] = 0;
    counter = counter + 1;

}
    while(cycle < cycles){
    counter = 0;
    while(counter < numOfGraphLeds){
    if(counter < numOfGraphLeds){
    bargraph[counter] = 1;

}
else{
    bargraph[counter] = 0;

}
    counter = counter + 1;
    delay(50);

}
    while(counter > 0){
    if( counter - 1 > numOfGraphLeds){
    bargraph[counter] = 1;

}
else{
    bargraph[counter] = 0;

}
    counter =  counter - 1;
    delay(50);

}
    cycle = cycle + 1;

}
    inFunMode = 0;

}
