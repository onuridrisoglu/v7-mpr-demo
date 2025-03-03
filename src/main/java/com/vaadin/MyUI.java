package com.vaadin;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.mpr.core.HasLegacyComponents;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.renderers.Renderer;
import org.apache.commons.collections.MapUtils;
import org.vaadin.grid.cellrenderers.editable.SimpleSelectRenderer;
import org.vaadin.grid.cellrenderers.editable.TextFieldRenderer;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Route("")
public class MyUI extends Div implements HasLegacyComponents {

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

        layout.addComponents(grid);
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setHeight("100%");

        add(layout);
    }

}
