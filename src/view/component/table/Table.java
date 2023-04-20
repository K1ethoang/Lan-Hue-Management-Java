package view.component.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import view.component.scroll.ScrollBarCus;

public class Table extends JTable {

    public Table() {
        getTableHeader().setDefaultRenderer(new TableHeader(this.getTableHeader().getDefaultRenderer()));
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        setDefaultRenderer(Object.class, new TableCell());
        setRowHeight(30);
        setAutoCreateRowSorter(true);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarCus());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(124, 150, 171));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(124, 150, 171));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(148, 175, 159), 2));
    }

    private class TableHeader extends DefaultTableCellRenderer {

        private TableCellRenderer defaultRenderer;

        public TableHeader(TableCellRenderer defaultRenderer) {
            this.defaultRenderer = defaultRenderer;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            com.setBackground(new Color(124, 150, 171));
            com.setForeground(new Color(0, 0, 0));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 16));
            return com;
        }
    }

    private class TableCell extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            com.setFont(com.getFont().deriveFont(14));
            if (isCellSelected(row, column)) {
                com.setFont(com.getFont().deriveFont(Font.ITALIC, 14));
                com.setForeground(new Color(255, 255, 255));
                if (row % 2 == 0) {
                    com.setBackground(new Color(14, 112, 152));
                } else {
                    com.setBackground(new Color(10, 77, 104));
                }
            } else {
                com.setFont(com.getFont().deriveFont(Font.PLAIN, 14));
                com.setForeground(new Color(0, 0, 0));
                if (row % 2 == 0) {
                    com.setBackground(new Color(254, 242, 244));
                } else {
                    com.setBackground(new Color(244, 238, 224));
                }
            }
            setBorder(new EmptyBorder(0, 5, 0, 5));
            return com;
        }

    }

}
