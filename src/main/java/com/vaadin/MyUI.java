package com.vaadin;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.mpr.LegacyWrapper;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.ButtonRenderer;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 */
@Route("")
public class MyUI extends Div {

    public MyUI() {
        setSizeFull();
        init();
    }

    protected void init() {

        final VerticalLayout layout = new VerticalLayout();

        Grid grid = new Grid();
        ButtonRenderer buttonRenderer = new ButtonRenderer(evt -> Notification.show("clicked"));
        grid.addColumn("name").setRenderer(buttonRenderer);
        grid.addColumn("surname");

        for(int i = 0; i < 10; i++) {
            grid.addRow("Name " + i, "Surname " + i);
        }
        
        grid.setReadOnly(true);
        grid.addSelectionListener(evt -> Notification.show("Selected a person"));

        layout.add(new LegacyWrapper(grid));
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setHeight("100%");

        add(layout);
    }

}
