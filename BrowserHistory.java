public class BrowserHistory {

    NodeBrowser head = null;
    NodeBrowser current = null;

    public BrowserHistory(String homepage) {
        head = new NodeBrowser();
        head.url = homepage;
        current = head;
    }

    public void visit(String url) {
        NodeBrowser newVisit = new NodeBrowser();
        newVisit.url = url;
        current.next = newVisit;
        newVisit.prev = current;
        current = newVisit;
    }

    public String back(int steps) {
        for(int i = 0; i< steps ; i++){
            if(current.prev == null){
                break;
            }
            current = current.prev;
        }
        return current.url;
    }

    public String forward(int steps) {
        for(int i = 0; i< steps ; i++){
            if(current.next == null){
                break;
            }
            current = current.next;
        }
        return current.url;
    }
}

class NodeBrowser {
    String url;
    NodeBrowser next;
    NodeBrowser prev;
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */