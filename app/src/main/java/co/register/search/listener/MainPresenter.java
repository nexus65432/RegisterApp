package co.register.search.listener;

import android.content.Context;
import android.support.annotation.NonNull;

public interface MainPresenter {

    /**
     * Attach to the View, this will bind a communication between UI
     */
    void onAttach(@NonNull Context context);

    /**
     * Get photos for the given input query from server
     * @param query
     */
    void getMatchingMenuItems(@NonNull String query);

    /**
     * Prepare to exit the UI, stop any schedulers and cleanup any other views
     */
    void prepareToExit();

    /**
     * Reset any values and make room for GC to cleanup any used resources
     */
    void onDetach();

}
