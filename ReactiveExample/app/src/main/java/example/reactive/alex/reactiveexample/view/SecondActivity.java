package example.reactive.alex.reactiveexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.AlteredCharSequence;
import android.text.InputType;
import android.view.View;
import android.widget.LinearLayout;

import java.text.NumberFormat;

import example.reactive.alex.reactiveexample.App;
import example.reactive.alex.reactiveexample.model.ActionType;
import trikita.anvil.RenderableView;
import trikita.jedux.Action;

import static trikita.anvil.BaseDSL.MATCH;
import static trikita.anvil.BaseDSL.dip;
import static trikita.anvil.BaseDSL.margin;
import static trikita.anvil.BaseDSL.o;
import static trikita.anvil.BaseDSL.padding;
import static trikita.anvil.BaseDSL.size;
import static trikita.anvil.BaseDSL.text;
import static trikita.anvil.DSL.button;
import static trikita.anvil.DSL.editText;
import static trikita.anvil.DSL.hint;
import static trikita.anvil.DSL.inputType;
import static trikita.anvil.DSL.linearLayout;
import static trikita.anvil.DSL.onClick;
import static trikita.anvil.DSL.orientation;

/**
 * Created by Alex on 01.06.2016.
 */
public class SecondActivity extends AppCompatActivity {

    private CharSequence editTextStringBuilder = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new RenderableView(this) {
            @Override
            public void view() {
                o(linearLayout(),
                        size(MATCH, MATCH),
                        padding(dip(20)),
                        orientation(LinearLayout.VERTICAL),

                        o(editText(),
                                text(editTextStringBuilder),
                                inputType(InputType.TYPE_CLASS_NUMBER),
                                hint("enter number to add")),

                        o(button(),
                                text("Add"),
                                margin(0, 0, 0, 20),
                                onClick(plusListener)));
            }
        });
    }

    private final View.OnClickListener plusListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            App.dispatch(new Action<>(ActionType.PLUS, Integer.parseInt(editTextStringBuilder.toString())));
        }
    };
}
