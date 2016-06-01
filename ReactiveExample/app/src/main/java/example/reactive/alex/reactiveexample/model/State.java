package example.reactive.alex.reactiveexample.model;

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

    public static class Reducer implements Store.Reducer<Action<ActionType, ?>, State> {
        public State reduce(Action<ActionType, ?> action, State oldState) {
            switch (action.type) {
                case INCREMENT:
                    return new State(oldState.count + 1);
                case DECREMENT:
                    return new State(oldState.count - 1 );
                case PLUS:
                    return new State(oldState.count + (Integer) action.value);
            }
            return oldState;
        }
    }
}
