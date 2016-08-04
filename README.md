# android-FragmentTransactionBackstack
Sample application demonstrating Fragments BackStack Transaction and its management

#Features
*  Add a fragment on top of the current stack  using addToBackStack()
     Frag A -> Frag B -> Frag C

*  On BackPress clear back stack

* Direct shift or GOTO  particular fragment 
    Frag A -> Frag B -> Frag C
    onBackPress :-
    Frag A <- Frag C (pops the top transactions from stack using popBackStackImmediate())
    
     
