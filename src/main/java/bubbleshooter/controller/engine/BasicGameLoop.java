package bubbleshooter.controller.engine;

import bubbleshooter.model.Model;
import bubbleshooter.model.gamemodality.GameStatus;
import bubbleshooter.view.View;

public class BasicGameLoop extends Thread implements GameLoop  {

    public static final int FPS = 60;
    private static final int SECOND = 1000;
    private static final int PERIOD = SECOND / FPS;
    private final View view;
    private final Model model;
    private volatile boolean isRunning;
    private volatile boolean isPaused;
    private Thread loopThread;

    public BasicGameLoop(final View view, final Model model) {
        super();
        this.setDaemon(true);
        this.view = view;
        this.model = model;
        this.isRunning = false;
        this.isPaused = true;
    }

    @Override
    public final void startLoop() {
        if (!this.isRunning()) {
            this.isRunning = true;
            this.isPaused = false;
            this.loopThread = new Thread(this, "loop");
            this.loopThread.start();
        }
    }

    @Override
    public final void run() {
        long lastFrameTime = System.currentTimeMillis();
        while (this.isRunning()) {
            final long currentFrameTime = System.currentTimeMillis();
            if (!this.isPaused()) {
                final long elapsed = currentFrameTime - lastFrameTime;
                this.updateAll(elapsed);
                this.waitForNextFrame(currentFrameTime);
            }
            lastFrameTime = currentFrameTime;
        }
        //this.view.showGameOver();
    }

    @Override
    public final synchronized void stopLoop() {
        this.isRunning = false;
        this.loopThread.interrupt(); 
    }

    @Override
    public final synchronized void pauseLoop() {
        this.isPaused = true;
    }

    @Override
    public final synchronized void resumeLoop() {
        this.isPaused = false;
    }

    public final boolean isPaused() {
        return this.isPaused;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    private void waitForNextFrame(final long currentFrameTime) {
       long sleepTime;
       final long remainingTime = PERIOD - currentFrameTime;
       if (remainingTime < 0) {
            sleepTime = PERIOD; 
       } else {
           sleepTime = remainingTime; 
       }
       try {
           Thread.sleep(sleepTime);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }

    private void updateAll(final double elapsed) {
        this.model.update(elapsed);
        this.view.update();
    }
}
