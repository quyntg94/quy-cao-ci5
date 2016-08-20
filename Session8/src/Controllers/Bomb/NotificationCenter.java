package Controllers.Bomb;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by giaqu on 8/10/2016.
 */
public class NotificationCenter {
    private Vector<BombSubscriber> subscribers;
    private Vector<FreezeSubcriber> freezzeSubcribers;
    private Vector<ProtectSubcriber> protectSubcribers;

    public NotificationCenter() {
        subscribers = new Vector<BombSubscriber>();
        freezzeSubcribers = new Vector<FreezeSubcriber>();
        protectSubcribers = new Vector<ProtectSubcriber>();
    }

    public void subsribe(BombSubscriber bombSubscriber) {
        subscribers.add(bombSubscriber);
    }

    public void subsribeFrezze(FreezeSubcriber bombSubscriber) {
        freezzeSubcribers.add(bombSubscriber);
    }

    public void subsribeProtect(ProtectSubcriber protectSubcriber) {
        protectSubcribers.add(protectSubcriber);
    }

    public void onBomExpode(int x, int y) {
        Iterator<BombSubscriber> bombSubscriberIterator = subscribers.iterator();
        while(bombSubscriberIterator.hasNext()) {
            BombSubscriber bombSubscriber = bombSubscriberIterator.next();
            if(!bombSubscriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                bombSubscriber.onBombExplode(x, y);
            }
        }
    }

    public void onFrezze(int x, int y) {
        Iterator<FreezeSubcriber> bombSubscriberIterator = freezzeSubcribers.iterator();
        while(bombSubscriberIterator.hasNext()) {
            FreezeSubcriber freezzeSubcriber = bombSubscriberIterator.next();
            if(!freezzeSubcriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                freezzeSubcriber.onFrezze(x, y);
            }
        }
    }

    public void onProtect(int x, int y) {
        Iterator<ProtectSubcriber> protectSubcriberIterator = protectSubcribers.iterator();
        while(protectSubcriberIterator.hasNext()) {
            ProtectSubcriber protectSubcriber = protectSubcriberIterator.next();
            if(!protectSubcriber.getGameObject().isAlive()) {
                protectSubcriberIterator.remove();
            } else {
                protectSubcriber.onProtect(x, y);
            }
        }
    }

    public static final NotificationCenter instance = new NotificationCenter();
}


