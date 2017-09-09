package udb.sv.com.analisisresultados.Controlador;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import udb.sv.com.analisisresultados.Modelo.Menu;
import udb.sv.com.analisisresultados.R;

/**
 * Created by Ariel on 9/9/2017.
 */

public class RecyclerViewMenuAdapter extends RecyclerView.Adapter<RecyclerViewMenuAdapter.ViewHolder> {

    private List<Menu> menus;
    private int layout;
    private onItemClickListener listener;
    private static  Context context;

    public RecyclerViewMenuAdapter(List<Menu> menus, int layout, onItemClickListener listener, Context context) {
        this.menus = menus;
        this.layout = layout;
        this.listener = listener;
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inlfamos el layout y le pasamos lso datos al constructor del view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //llamamos al metodo bind del viewholder pasandole el objdeto y un listener
        holder.bind(menus.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        //Elementos UI a rellenar
        public TextView txtTitulo;
        public TextView txtDescripcion;
        public CardView cvPoster;

        public ViewHolder(View v){

            //recibe la vista completa para que la rendericemos, pasamos parametros a constructor padre
            // aqui tambien manejamos los datos de logioca para extraer datos y hacer referencias con los elementoss
            super(v);
            this.txtTitulo =(TextView) v.findViewById(R.id.txtTitulo);
            this.txtDescripcion = (TextView) v.findViewById(R.id.txtDescripcion);
            cvPoster = (CardView) v.findViewById(R.id.cardViewPoster);
        }

        public void bind(final Menu menu, final  onItemClickListener listener){
            //procesamos los datos para renderizar
            txtTitulo.setText(menu+"");
            txtDescripcion.setText(menu.getDescripcion());
            cvPoster.setBackgroundColor(getMatColor("400", context));
            // this.textViewmenu.setText(menu.getName());
            /// definimos que por cada elemento del recycler view tenemos un listener que se va a comportart de la siguiente manera
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(menu, getAdapterPosition());
                }
            });

        }

    }
    ///declaramos las interfaces con los metodos a implementar
    public interface onItemClickListener{
        void onItemClick(Menu menu, int position);
    }


    private static int getMatColor(String typeColor, Context contexto)
    {
        int returnColor = Color.BLACK;
        int arrayId = contexto.getResources().getIdentifier("mdcolor_" + typeColor, "array", contexto.getApplicationContext().getPackageName());

        if (arrayId != 0)
        {
            TypedArray colors = contexto.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.BLACK);
            colors.recycle();
        }
        return returnColor;
    }
}
