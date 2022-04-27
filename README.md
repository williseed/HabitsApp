project@ucmo.edu# HabitsApp
Below is how the project is divided as of right now (I will try my best to split the workload as evenly as possible). Each person will be responsible for the items with their name on it. That person will be in charge of how it looks and how it functions. Also, in the final presentation, each person will present the pages/functionalities they have worked on. 
1. Login Page (activity_login.xml): Will
2. Home Page (activity_home.xml): Mark
3. Habits List (activity_habits.xml): Zack
4. Habits Progress (activity_porgess.xml): Michael
5. Habits Edit (activity_edit.xml): Aaron with help from Zack

Feel free to modify the page you are assigned to as you see fit, even the user interface.

CREDENTIALS: password: " " (just a space), username: " " (just a space)

Whatever class you want to add the the main top bar to add this code: 
    // ALL THE ACTION BAR CODE IS BELOW/////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_home:
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_logout:
                LoginActivity.loggedIn = false;
                Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //////////////////////////////////////////////////////////////////////////////
