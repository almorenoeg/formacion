package com.terralcode.gestion.frontend.view.widgets.notes;

import com.naoset.framework.frontend.view.widgets.Widget;
import com.vaadin.cdi.CDIView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author Ezequiel
 */
@CDIView
public class NotesView extends Widget {

    @Override
    protected String caption()
    {
        return "Notas";
    }

    protected Component buildContent()
    {
        return buildNotes();
    }

    private Component buildNotes() {
        TextArea notes = new TextArea("Notas");
        notes.setValue("Recuerda que:\n· Esto es una versión de demostración\n· Se añadirán mas opciones \n· ");
        notes.setSizeFull();
        notes.addStyleName(ValoTheme.TEXTAREA_BORDERLESS);
        Component panel = new Panel(notes);
        panel.addStyleName("notes");
        panel.setSizeFull();
        return panel;
    }



}
