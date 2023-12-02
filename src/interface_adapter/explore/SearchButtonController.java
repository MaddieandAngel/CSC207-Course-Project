package interface_adapter.explore;

import use_case.SearchButton.SearchButtonInputBoundary;

public class SearchButtonController {

    final SearchButtonInputBoundary searchButtonInputBoundary;

    public SearchButtonController(SearchButtonInputBoundary searchButtonInputBoundary) {
        this.searchButtonInputBoundary = searchButtonInputBoundary;
    }

    public void execute(){
        searchButtonInputBoundary.execute();

    }
}
