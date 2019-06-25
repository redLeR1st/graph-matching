import io.jbotsim.core.Topology;
import io.jbotsim.ui.JViewer;

public class Main {
    public static void main(String[] args) {
        Topology tp = new Topology();
        tp.setDefaultNodeModel(PPNodeImpl.class);
        tp.setTimeUnit(100);
        new PPScheduler(tp);
        new JViewer(tp);
        tp.start();
    }
}
