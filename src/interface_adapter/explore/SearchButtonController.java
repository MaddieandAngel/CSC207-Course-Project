package interface_adapter.explore;

import use_case.SearchButton.SearchButtonInputBoundary;

public class SearchButtonController {

    //TODO: Add constructor, implement
    final SearchButtonInputBoundary searchButtonInputBoundary;

    public SearchButtonController(SearchButtonInputBoundary searchButtonInputBoundary) {
        this.searchButtonInputBoundary = searchButtonInputBoundary;
    }

    public void execute(){
        //TODO: implement
        searchButtonInputBoundary.execute();

    }
}
