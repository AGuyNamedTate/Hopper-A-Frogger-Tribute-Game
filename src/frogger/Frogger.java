/*
 @author: 
 */
package frogger;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 *
 * @author TateM
 */
public class Frogger extends Canvas implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static final int WIDTH = 640, HEIGHT = 640;

    private Thread thread;
    public static boolean running = false;

    private Random r = new Random();
    private BasicEnemy enemy;
    private Handler handler;
    private HUD hud;
    private int laneHigh = 512 - 72;
    private int temp;
    private int enemyLong = 0;
    public int direct = 1;
    float speed = r.nextFloat();

    public Frogger() {
        // initialize handler first
        handler = new Handler();
        //so the program knows to look for key input
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Hopper: A Kangaroo Quest", this);

        hud = new HUD();

        //for (int i = 0; i < 50; i++) {
        //adding a second player
        //handler.addObject(new Player(160, 100, ID.Player2));
        //adding enemies in lanes(like a car should be)
        handler.addObject(new Bush(0, 88, ID.Bush));
        for (int i = 0; laneHigh > 88; i++) {
            
            lane();
            laneHigh = laneHigh - 32;
            enemyLong = r.nextInt(19) * 32;
        }
        int grassy=472;
        for(int i = 0; i<4;i++){
            
            handler.addObject(new GrassLand(0,grassy,ID.Grass));
            grassy+=32;
        }
        handler.addObject(new Player(304, HEIGHT - 31, ID.Player, handler));

        for (int i = 0; i < 3; i++) {
            handler.addObject(new BasicJoey((r.nextInt(20) * 32), (r.nextInt(10) * 32) + 120, ID.Joey, handler));
        }

    }

    public synchronized void start() {
        thread = new Thread((Runnable) this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //used for fps display. very important. Also makes game work and update
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 100000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);

                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        hud.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    public void spawn(int type) {

        switch (type) {
            case 1:
                handler.addObject(new BasicEnemy(enemyLong, laneHigh, ID.Enemy, getSpeed() * getDirection()));
                break;
            case 2:
                handler.addObject(new BasicEnemy(enemyLong, laneHigh, ID.Bus, getSpeed() * getDirection()));
                break;
            default:
                handler.addObject(new BasicEnemy(enemyLong, laneHigh, ID.Bike, getSpeed() * getDirection()));
                break;
        }
    }

    public void setDirection(int direct) {
        this.direct = r.nextInt(2);
        if (this.direct == 0) {
            this.direct = -1;
        }
    }

    public int getDirection() {
        return this.direct;
    }

    public void setSpeed(float speed) {
        speed = r.nextFloat() - 0.44112f;
        this.speed = speed;
        if (this.speed == 0) {
            this.speed = 0.35f;
        }
        System.out.println("Speed is: " + this.speed);
    }

    public float getSpeed() {
        return speed;
    }

    public int pickSpawn(float sped) {
        int spawn;
        if (sped <= -0.75) {
            spawn = 2;
        } else if (sped <= -0.5) {
            spawn = 3;
        } else if (sped <= -0.25) {
            spawn = 4;
        } else if (sped <= 0.25) {
            spawn = 5;
        } else if (sped <= 0.5) {
            spawn = 4;
        } else if (sped <= 0.75) {
            spawn = 3;
        } else {
            spawn = 2;
        }
        return spawn;
    }

    public int pickSpawnLength(int spwn) {
        int space =0;
        switch (spwn) {
            case 2:
                space += 360;
                break;
            case 3:
                space += 250;
                break;
            case 4:
                space += 150;
                break;
            case 5:
                space += 100;
                break;
            default:
                break;
        }
        return space;
    }
    
    public void lane(){
        //int laneType = r.nextInt(3);
        int laneType = r.nextInt(2);
        switch(laneType){
            case 1:
                setDirection(this.direct);
                setSpeed(this.speed);

                handler.addObject(new Lane(0, laneHigh, ID.Lane));
                int type = r.nextInt(3);
                int spawnNum =pickSpawn(getSpeed());
                for (int n = 0; n < spawnNum; n++) {
                    spawn(type);
                    enemyLong += pickSpawnLength(spawnNum);

                }
            break;
           /* case 2:
                handler.addObject(new MudPit(0,laneHigh,ID.MudPit));
                for(int i = 0;i<4;i++){
                 handler.addObject(new Log(i*60,laneHigh,ID.Log));
                }
                
                break;*/
            default:
                handler.addObject(new Outback(0,laneHigh,ID.Outback));
                break;
            
                
        }
        
    }

    public static void main(String[] args) {
        // TODO code application logic here

        new Frogger();

    }

}
//