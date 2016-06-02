package example.reactive.alex.reactiveexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.AlteredCharSequence;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import static trikita.anvil.BaseDSL.onTextChanged;
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
import static trikita.anvil.DSL.rawInputType;

/**
 * Created by Alex on 01.06.2016.
 */
public class SecondActivity extends AppCompatActivity {

    private CharSequence editTextString;

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
                                text(editTextString),
                                rawInputType(InputType.TYPE_CLASS_NUMBER),
                                onTextChanged(ontextChangeListener),
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
            if (!TextUtils.isEmpty(editTextString)) {
                App.dispatch(new Action<>(ActionType.PLUS, Integer.parseInt(editTextString.toString())));
            }
        }
    };

    private final TextWatcher ontextChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            editTextString = s;
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
