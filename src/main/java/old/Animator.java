package old;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Eric.Graham on 4/7/2017.
 */
public class Animator extends TimerTask {
    private static Animator instance;
    private List<Animated> objects = new ArrayList<>(), toRemove = new ArrayList<>();
    private boolean interrupted = false;

    public interface Animated {
        void animate();
    }

    public void addObject(Animated object) {
        objects.add(object);
    }

    public boolean removeObject(Animated object) {
        if (objects.contains(object)) {
            toRemove.add(object);
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        if (!interrupted)
            objects.forEach(Animated::animate);
        new CopyOnWriteArrayList<>(toRemove).forEach(object -> {
            objects.remove(object);
            toRemove.remove(object);
        });
    }

    public void interrupt() {
        interrupted = true;
        this.cancel();
    }

    public static Animator getInstance() {
        if (instance == null) {
            instance = new Animator();
            new Timer().scheduleAtFixedRate(instance, 0, 250);
        }
        return instance;
    }
}
