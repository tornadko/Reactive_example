package example.reactive.alex.reactiveexample;

import trikita.jedux.Action;
import trikita.jedux.Store;

/**
 * Created by Alex on 29.05.2016.
 */
public class State {
    public final int count;

    public State(int count) {
        this.count = count;
    }

    static class Reducer implements Store.Reducer<Action<ActionType, ?>, State> {
        public State reduce(Action<ActionType, ?> a, State oldState) {
            switch (a.type) {
                case INCREMENT:
                    return new State(oldState.count + 1);
                case DECREMENT:
                    return new State(oldState.count - 1 );
            }
            return oldState;
        }
    }
}
