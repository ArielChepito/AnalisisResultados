package udb.sv.com.analisisresultados.Vista;

import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import udb.sv.com.analisisresultados.R;

public class Analisis3 extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analisis3);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = null;
            try
            {

                int pag = getArguments().getInt(ARG_SECTION_NUMBER);
                if(pag ==1)
                {
                    rootView = inflater.inflate(R.layout.fragment_analisis3_1, container, false);
                    final EditText caja1 = (EditText) rootView.findViewById(R.id.txtCM);
                    final EditText caja2 = (EditText) rootView.findViewById(R.id.txtFactor);
                    final EditText resultado = (EditText) rootView.findViewById(R.id.txtResultados);
                    resultado.setKeyListener(null);
                    Button boton = (Button) rootView.findViewById(R.id.btnCalcular);
                    boton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(caja1.getText().toString().trim().length() != 0 &&
                                    caja2.getText().toString().trim().length() != 0)
                            {

                                double cm = Double.parseDouble(caja1.getText().toString().trim());
                                double result = 0.00;
                                switch (caja2.getText().toString().trim())
                                {
                                    case "metros":
                                    case "METROS":
                                    case "me":
                                    case "ME":
                                    case "m":
                                        result = (cm/100);
                                        break;
                                    case "pulgadas":
                                    case "PULGADAS":
                                    case "pu":
                                    case "PU":
                                    case "p":
                                        result = (cm*0.393701);
                                        break;
                                    case "pies":
                                    case "PIES":
                                    case "pi":
                                    case "PI":
                                        result = (cm*0.0328084);
                                        break;
                                    case "decimetros":
                                    case "DECIMETROS":
                                    case "DE":
                                    case "de":
                                    case"d":
                                        result = (cm*0.1);
                                        break;
                                    default:



                                }

                                resultado.setText("Resultado: " +  String.format("%.2f", result));
                                caja1.setText("");
                                caja2.setText("");


                            }
                            else{
                                resultado.setText("Ingrese algo");

                            }

                        }
                    });





                }
                else{
                    rootView = inflater.inflate(R.layout.fragment_analisis3_2, container, false);
                    final EditText caja1 = (EditText) rootView.findViewById(R.id.txtMasa);
                    final EditText caja2 = (EditText) rootView.findViewById(R.id.txtNew);
                    final EditText resultado = (EditText) rootView.findViewById(R.id.txtResultados);
                    final double  fuckingGravity = 9.8;
                    Button boton = (Button) rootView.findViewById(R.id.btnCalcularFama);
                    boton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(caja1.getText().toString().trim().length() == 0 &&
                                    caja2.getText().toString().trim().length() != 0)
                            {

                                caja1.setText(""+String.format("%.2f",
                                        (((Double.parseDouble(caja2.getText().toString().trim())))/
                                        fuckingGravity)));


                            }

                            if(caja1.getText().toString().trim().length() != 0 &&
                                    caja2.getText().toString().trim().length() == 0)
                            {

                                caja2.setText(""+String.format("%.2f",
                                        (((Double.parseDouble(caja1.getText().toString().trim())))*
                                                fuckingGravity)));


                            }

                        }
                    });




                }




            }
            catch(Exception e)
            {


            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

    }
}
