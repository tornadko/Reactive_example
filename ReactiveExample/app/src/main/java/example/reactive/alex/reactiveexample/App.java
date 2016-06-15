package example.reactive.alex.reactiveexample;

import android.app.Application;

import example.reactive.alex.reactiveexample.model.ActionType;
import example.reactive.alex.reactiveexample.model.ImmutableState;
import example.reactive.alex.reactiveexample.model.Reducer;
import example.reactive.alex.reactiveexample.model.State;
import trikita.jedux.Action;
import trikita.jedux.Store;

/**
 * Created by Alex on 01.06.2016.
 */
public class App extends Application {
    private static App instance;

    private Store<Action<ActionType, ?>, State> store;

    @Override
    public void onCreate() {
        super.onCreate();
        App.instance = this;

        this.store = new Store<>(new Reducer(), ImmutableState.builder().count(0).build());
    }

    public static State getState() {
        return instance.store.getState();
    }

    public static State dispatch(Action<ActionType, ?> action) {
        return instance.store.dispatch(action);
    }
}
