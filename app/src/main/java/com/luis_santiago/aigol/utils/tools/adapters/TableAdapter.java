package com.luis_santiago.aigol.utils.tools.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.*;
import com.luis_santiago.aigol.utils.tools.pojos.TableTeam;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by legendarywicho on 7/31/17.
 */

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableAdapterHolder>{


    @Override
    public TableAdapter.TableAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TableAdapterHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

     static class TableAdapterHolder extends RecyclerView.ViewHolder {
         public TableAdapterHolder(View itemView) {
             super(itemView);
         }
     }
}
