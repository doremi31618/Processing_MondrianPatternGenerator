
import com.hamoid.*;

VideoExport videoExport;
int number = 250;
PVector SquareRange = new PVector(20.0, 80.0);

void setup(){
  size(512,512);
  
  //frameRate(10);
  videoExport = new VideoExport(this, "Mondrian.mov");
  videoExport.setFrameRate(10);  
  videoExport.startMovie();
}

int time_frame = 0; 
void draw(){
  background(0);
  for(int i=0; i<number; i++){
    int rnd_Rcolor = (int)random(256);
    int rnd_Gcolor = (int)random(256);
    int rnd_Bcolor = (int)random(256);
    int rnd_width = (int)random(SquareRange.x, SquareRange.y);
    int rnd_x = (int)random(width);
    int rnd_y = (int)random(height);
    fill(rnd_Rcolor,rnd_Gcolor,rnd_Bcolor);
    rect(rnd_x, rnd_y, rnd_width, rnd_width);
  }
  videoExport.saveFrame();
  time_frame +=1;
  if(time_frame > 600){
    videoExport.endMovie();
    exit();
  }
}