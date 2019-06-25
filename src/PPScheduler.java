import io.jbotsim.core.Color;
import io.jbotsim.core.Link;
import io.jbotsim.core.Node;
import io.jbotsim.core.Topology;
import io.jbotsim.core.event.ClockListener;

import java.util.List;

public class PPScheduler implements ClockListener {
    Topology tp;

    public PPScheduler(Topology topology) {
        tp = topology;
        tp.addClockListener(this);
    }

    @Override
    public void onClock() {
        // Retrieve all links
        List<Node> nodes = tp.getNodes();
        for (Node n : nodes) {
            if (n.getLinks().isEmpty()) {
                n.setColor(Color.BLUE);
            }
        }

        List<Link> links = tp.getLinks();
        if ( ! links.isEmpty() ) {
            // Pick a link at random
            Link selectedLink = links.get((int) (Math.random() * links.size()));
            // Make it bold for visualization
            drawInteraction(selectedLink);
            // Pick initiator side at random
            PPNode initiator = (PPNode) selectedLink.endpoint((int) (Math.random() * 2));
            PPNode responder = (PPNode) selectedLink.getOtherEndpoint(initiator);
            // Perform interaction
            initiator.onMessage(responder, selectedLink);
        }
    }

    // Draw a given link in bold (and unbold others)
    public void drawInteraction(Link selectedLink){
        for (Link link : tp.getLinks()) {
            if (link.getWidth() != 5) {
                link.setWidth(1);
                selectedLink.setColor(Color.BLACK);
            }
        }
        selectedLink.setWidth(2);
        //selectedLink.setColor(Color.CYAN);
    }
}