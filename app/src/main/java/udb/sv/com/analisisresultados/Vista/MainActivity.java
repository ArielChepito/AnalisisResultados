package udb.sv.com.analisisresultados.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import udb.sv.com.analisisresultados.Controlador.RecyclerViewMenuAdapter;
import udb.sv.com.analisisresultados.Modelo.Menu;
import udb.sv.com.analisisresultados.R;

public class MainActivity extends AppCompatActivity {
    public static final String URL = "udb.sv.com.analisisresultados.Vista.";



    /*variables*/

    private int counter = 0;
    private List<Menu> Menus;
    private RecyclerView recyclerViewMenu;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager MyLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            Menus= this.getAllMenus();
            recyclerViewMenu = (RecyclerView) findViewById(R.id.recycler_view_main);
            recyclerViewAdapter = new RecyclerViewMenuAdapter(Menus, R.layout.menu_item,new RecyclerViewMenuAdapter.onItemClickListener(){
                @Override
                public void onItemClick(Menu menu, int position) {
                    //Toast.makeText(MainActivity.this,Menu + " - "+ position,Toast.LENGTH_LONG).show();
                    //deleteMenu(position);
                    try {
                        if(Class.forName(URL+menu.getClase())  != null)
                        {

                            Intent intent = new Intent(MainActivity.this, Class.forName(URL+menu.getClase()));
                            startActivity(intent);
                        }
                    } catch (ClassNotFoundException e) {
                        Log.d("Erorrsito",e.getMessage());
                    }


                }
            }, this);
            //todos los tipos de layout manager con los que se puede jugar con el recycler view
            MyLayoutManager = new LinearLayoutManager(this);
            //MyLayoutManager = new GridLayoutManager(this,2);
            // MyLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            //solo en caso que sepamos que el tamaño del layout no va a cambiar ahrehgamos esto e incrementa el rendimiento, aunque de nada sirve con el StraggeredGridLayout porque cambia los tamaños
            recyclerViewMenu.setHasFixedSize(true);
            //animacion por defecto
            recyclerViewMenu.setItemAnimator(new DefaultItemAnimator());

            recyclerViewMenu.setLayoutManager(MyLayoutManager);
            recyclerViewMenu.setAdapter(recyclerViewAdapter);
        }catch(Exception e)
        {
            Log.d("Erorrsito",e.getMessage());
        }

    }

    private List<Menu> getAllMenus(){
        return new ArrayList<Menu>(){{
            add(new Menu("Analisis l",
                    "Investigar cómo crear Layouts anidados (Hace uso de LinearLayout y RelativeLayout juntos).",
                    "analisis1"));
            add(new Menu("Complementario  l","descripcion","d"));
            add(new Menu("Analisis 2","descripcion","d"));
            add(new Menu("Complementario  2","descripcion","d"));
            add(new Menu("Complementario  3","descripcion","d"));



        }};
    }
}
