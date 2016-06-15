package example.reactive.alex.reactiveexample.model;

import trikita.jedux.Action;
import trikita.jedux.Store;

public class Reducer implements Store.Reducer<Action<ActionType, ?>, State> {
        public State reduce(Action<ActionType, ?> action, State oldState) {
            switch (action.type) {
                case INCREMENT:
                    return newState(oldState, 1);
                case DECREMENT:
                    return newState(oldState, -1);
                case PLUS:
                    return newState(oldState, (Integer)action.value);
            }
            return oldState;
        }

    private ImmutableState newState(State oldState, int valueToAdd) {
        return ImmutableState.builder()
                .count(oldState.count() + valueToAdd)
                .build();
    }
}