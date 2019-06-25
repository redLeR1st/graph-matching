import io.jbotsim.core.Link;
import io.jbotsim.core.Node;

public abstract class PPNode extends Node {
    // Assign default initial state to underlying node
    public abstract void onStart();
    // Assign distinguished initial state to underlying node
    public abstract void onSelection();
    // Execute interaction (from the initiator side)
    public abstract void onMessage(Node responder, Link selectedLink);
}