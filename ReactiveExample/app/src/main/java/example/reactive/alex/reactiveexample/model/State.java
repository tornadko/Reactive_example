package example.reactive.alex.reactiveexample.model;

import org.immutables.value.Value;

/**
 * Created by Alex on 29.05.2016.
 */



@Value.Immutable
public interface State {

    int count();
}
