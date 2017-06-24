
package com.anish.so.q0003;

import java.util.List;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;

public class SampleDynamicMenu {

	@AboutToShow
	public void aboutToShow(final List<MMenuElement> items) {

		for (int i = 0; i < 3; i++) {
			final MDirectMenuItem menuItem;
			menuItem = MMenuFactory.INSTANCE.createDirectMenuItem();
			menuItem.setLabel("Item " + (i + 1));
			menuItem.setContributionURI(
					"bundleclass://com.anish.so.q0003.baseplugin/com.anish.so.q0003.DynamicMenuHandler");
			items.add(menuItem);
		}
	}

}
