package states;

import utl.console.Console;

public abstract class State implements Runnable{
    
    protected boolean running = false;
    protected Thread thread;
    
    public abstract void tick();
    public abstract void render();
    
    @Override
    public abstract void run();
    
    public void start(){
        if(this.running)
            return;
        try{
            thread = new Thread(this);
            thread.start();
            this.running = true;
        }catch(Exception e){
            Console.flag("Error starting a State.", e);
        }
    }
    
    public void stop(){
        if(this.running==false)
            return;
        try{
            thread.join();
            this.running = false;
        }catch(Exception e){
            Console.flag("Error stopping a State", e);
        }
    }
    
}
