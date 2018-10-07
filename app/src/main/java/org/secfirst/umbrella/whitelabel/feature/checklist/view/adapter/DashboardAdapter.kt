package org.secfirst.umbrella.whitelabel.feature.checklist.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.checklist_dashboard_item.view.*
import kotlinx.android.synthetic.main.head_section.view.*
import org.secfirst.umbrella.whitelabel.R
import org.secfirst.umbrella.whitelabel.data.database.checklist.Dashboard
import org.secfirst.umbrella.whitelabel.misc.ITEM_VIEW_TYPE_HEADER
import org.secfirst.umbrella.whitelabel.misc.ITEM_VIEW_TYPE_ITEM

class DashboardAdapter(private val dashboardItems: List<Dashboard.Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private fun isHeader(position: Int) = dashboardItems[position].label.isNotBlank()

    override fun getItemCount() = dashboardItems.size

    override fun getItemViewType(position: Int) = if (isHeader(position)) ITEM_VIEW_TYPE_HEADER else ITEM_VIEW_TYPE_ITEM

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.checklist_item, parent, false)

        if (viewType == ITEM_VIEW_TYPE_HEADER) {
            val headerView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.head_section, parent, false)
            return DashboardHeaderViewHolder(headerView)
        }
        return DashboardHolder(view)
    }

    class DashboardHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(title: String) {
            itemView.sectionText.text = title
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isHeader(position)) {
            holder as DashboardHeaderViewHolder
            holder.bind(dashboardItems[position].label)
        } else {
            holder as DashboardHolder
            holder.bind(dashboardItems[position])
        }
    }

    class DashboardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dashboardItem: Dashboard.Item) {
            with(dashboardItem) {
                itemView.itemTitle.text = title
                itemView.itemPercentage.text = progress.toString()
            }
        }
    }
}