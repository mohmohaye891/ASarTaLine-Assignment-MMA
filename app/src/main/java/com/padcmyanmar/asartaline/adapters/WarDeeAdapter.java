package com.padcmyanmar.asartaline.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.padcmyanmar.asartaline.R;
import com.padcmyanmar.asartaline.data.vos.ASTLWarDeeVO;
import com.padcmyanmar.asartaline.data.vos.SearchResultsVO;
import com.padcmyanmar.asartaline.delegates.WarDeeDelegate;
import com.padcmyanmar.asartaline.viewholders.WarDeeViewHolder;

import java.util.ArrayList;
import java.util.List;

public class WarDeeAdapter extends RecyclerView.Adapter<WarDeeViewHolder> implements Filterable{

    private WarDeeDelegate mWarDeeDelegate;

   // private List<ASTLWarDeeVO> mWarDeeList;
   private List<ASTLWarDeeVO> mWarDeeList;

    private List<ASTLWarDeeVO> mFilterList;


    public WarDeeAdapter(WarDeeDelegate mWarDeeDelegate) {
        this.mWarDeeDelegate = mWarDeeDelegate;
        mWarDeeList = new ArrayList<>();
        mFilterList = new ArrayList<>();
    }

    @NonNull
    @Override
    public WarDeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_item_food, parent, false);
        return new WarDeeViewHolder(view, mWarDeeDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull WarDeeViewHolder holder, int position) {
       // holder.setWarDeeData(mWarDeeList.get(position));
        holder.setWarDeeData(mFilterList.get(position));
    }

    @Override
    public int getItemCount() {
        //return mWarDeeList.size();
        return mFilterList.size();
    }

    public void setWarDeeList(List<ASTLWarDeeVO> warDeeList){
        mWarDeeList = warDeeList;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()){
                    mFilterList = mWarDeeList;
                }else {
                    ArrayList<ASTLWarDeeVO> filteredList = new ArrayList<>();

                    for (ASTLWarDeeVO astlWarDeeVO : mWarDeeList) {
                        if (astlWarDeeVO.getName().toLowerCase().contains(charString)
                                || astlWarDeeVO.getPriceRangeMax().toLowerCase().contains(charString)){
                            filteredList.add(astlWarDeeVO);
                        }
                    }
                    mFilterList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilterList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilterList = (ArrayList<ASTLWarDeeVO>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
