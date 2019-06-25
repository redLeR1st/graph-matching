import io.jbotsim.core.Color;
import io.jbotsim.core.Link;
import io.jbotsim.core.Message;
import io.jbotsim.core.Node;

import java.util.ArrayList;
import java.util.List;

public class PPNodeImpl extends PPNode {

    public PPNodeImpl(){}

    @Override
    public void onStart() {
        setColor(Color.blue);
    }
    @Override
    public void onSelection() {
        setColor(Color.red);
    }
    @Override
    public void onMessage(Node responder, Link selectedLink) {
        PPNodeImpl res = (PPNodeImpl)responder;
        if (this.getBoldLinks().isEmpty() && res.getBoldLinks().isEmpty()) {
            selectedLink.setWidth(5);
            this.setColor(Color.RED);
            res.setColor(Color.RED);
            selectedLink.setColor(Color.RED);
        } else if (this.getBoldLinks().isEmpty() && this.getColor().equals(Color.RED)){
            this.setColor(Color.BLUE);
        } else if (res.getBoldLinks().isEmpty() && res.getColor().equals(Color.RED)){
            res.setColor(Color.BLUE);
        }
    }

    List<Link> getBoldLinks(){
        List<Link> a = new ArrayList<>();
        for (Link temp : this.getLinks()) {
            if (temp.getWidth() == 5) {
                a.add(temp);
            }
        }
        return a;
    }
}