package sportsmobile.futebolandroid;


/*
public class BaseActivity extends MarshmallowSupportActivity implements IBaseView {
    private ProgressDialog progressDialog;
    private Snackbar fixedSnackbar;
    public static final String FULL_TOKEN = "Token token=";
    private static final String kUPDATE_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    public void dbg(String content) {
        Log.d("[DBG] =========>" + getClass().getCanonicalName(), content);
    }
    //endregion

    //region UI - Basic configuration

    public void configureBasicToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String topColor = UserGsemdUtils.getBackgroundColor(this);

        if (!Strings.isNullOrEmpty(topColor)) {

            ScreenUtils.updateStatusBarcolor(this, topColor);

            ColorDrawable cd = new ColorDrawable(Color.parseColor(topColor));
            getSupportActionBar().setBackgroundDrawable(cd);
        }
    }

    public void configureToolbarWithTitle(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String topColor = UserGsemdUtils.getBackgroundColor(this);

        if (!Strings.isNullOrEmpty(topColor)) {

            ScreenUtils.updateStatusBarcolor(this, topColor);

            ColorDrawable cd = new ColorDrawable(Color.parseColor(topColor));
            getSupportActionBar().setBackgroundDrawable(cd);
        }
    }


    public ColorDrawable getBasicButtonColor() {
        return new ColorDrawable(Color.parseColor(UserGsemdUtils.getButtonColor(this)));
    }


    public void createButtonsOpt(@Nullable Integer backGroundColor, String buttonTitle, int actionId,
                                 ShopCustomDialog shopCustomDialog, View.OnClickListener onClickListener){
        ButtonBuilder button = new ButtonBuilder((LinearLayout)shopCustomDialog.getBtnContainer(),
                AdaliveApplication.getInstance().getApplicationContext(),actionId);

        button.setTitleButton(buttonTitle,R.color.white,19f)
                .setBackGround(backGroundColor == null ? R.drawable.background_button_green: backGroundColor)
                .setListener(onClickListener);
        button.build();
    }


    public void initToolbar(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(title != null){
            getSupportActionBar().setTitle(title);
        }

        String topColor = UserGsemdUtils.getBackgroundColor(this);

        if (!Strings.isNullOrEmpty(topColor)) {

            ScreenUtils.updateStatusBarcolor(this, topColor);

            ColorDrawable cd = new ColorDrawable(Color.parseColor(topColor));
            getSupportActionBar().setBackgroundDrawable(cd);
        }
    }


    @Override
    public void showCustomDialog(String title, String message, Dialog.OnClickListener positiveClickListener) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, positiveClickListener)
                .create()
                .show();
    }

    @Override
    public void showCustomDialog(String title, String message, Dialog.OnClickListener positiveClickListener,
                                 Dialog.OnClickListener negativeClickListener) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, positiveClickListener)
                .setNegativeButton(android.R.string.cancel, negativeClickListener)
                .create()
                .show();
    }

    public void showError(String errTitle, String errMsg) {

        final CustomDialog customDialog =  DialogCreator.showMessageDialog(this,
                errMsg,
                errTitle,
                CustomDialog.DIALOG_TYPE.ERROR);

        View views = customDialog.findViewById(R.id.btnContainer);
        Button positive = (Button) views.findViewById(R.id.btn_positive);
        positive.setText(R.string.title_btn_ok);
        positive.setBackground(ContextCompat.getDrawable(this,R.drawable.background_red));
        positive.setTextColor(ContextCompat.getColor(this,R.color.white));
        positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.dismiss();
            }
        });
    }

    @Override
    public void showProgress() {
        if (progressDialog == null) {
            showProgressDlg();
        } else if(!progressDialog.isShowing()) {
            showProgressDlg();
        }
    }

    private void showProgressDlg(){
        progressDialog = ProgressDialog.show(this, null, getText(R.string.MESSAGE_ACTIVITY_INDICATOR_LOADING),
                true, false);
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog.hide();
        }
    }

    public void showRunningProgress() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            showProgressDlg();
            return;
        }

        showProgress();
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSnackMessage(String message) {}

    @Override
    public void showNoConnectionSnackMessage() {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator_layout), getText(R.string.ERROR_ALERT_MESSAGE_NO_CONNECTION), Snackbar.LENGTH_LONG);
        TextView txtMessage = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        txtMessage.setTextColor(ContextCompat.getColor(this, R.color.no_connection_yellow));
        snackbar.show();
    }

    @Override
    public void showFixedSnackMessage(String message) {
        fixedSnackbar = Snackbar.make(findViewById(R.id.coordinator_layout), message, Snackbar.LENGTH_INDEFINITE);
        fixedSnackbar.show();
    }

    @Override
    public void hideFixedSnackMessage() {
        if (fixedSnackbar == null)
            return;
        fixedSnackbar.dismiss();
        fixedSnackbar = null;
    }
    //endregion

    //region Events
    @Override
    public void hideKeyboard() {
        try {
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion

    //region Services and more

    public static String getUserToken(){
        SharedPrefsHelper sharedPrefsHelper = AdaliveApplication.getInstance().getSharedPrefsHelper();
        StringBuilder fullToken = new StringBuilder();
        String tokenAux = null;
        if(sharedPrefsHelper != null) {
            tokenAux =  sharedPrefsHelper.get(EnumLoginTypeCategory.USER_TOKEN.getUserToken, "");
        }

        return fullToken.append(FULL_TOKEN).append(tokenAux).toString();
    }

    public boolean isGooglePlayServicesAvailable() {
        return false;
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int status = googleApiAvailability.isGooglePlayServicesAvailable(this);
        if(status != ConnectionResult.SUCCESS) {
            if(googleApiAvailability.isUserResolvableError(status)) {
                googleApiAvailability.getErrorDialog(this, status, 2404).show();
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean isOnline() {
        return NetworkStatsUtil.isConnected(this);
    }

    @Override
    public String getResourceString(int resourceId) {
        return getString(resourceId);
    }


    @Override
    public void saveUserIntoSharedPreferences(UserGsemd response) {
        UserGsemdUtils.saveUserGsemd(this, response);
    }

    @Override
    public void userLogOut() {
        UserGsemdUtils.clearSharedPrefs(this);
    }

    @Override
    public void loadApplicationBackground() {
        String backgroundUrl = AdaliveApplication.getInstance().getLayoutParam().getBackgroundImage();
        loadBackground(backgroundUrl);
    }

    @Override
    public void loadCachedBackground() {
        String backgroundUrl = UserGsemdUtils.getCachedBackgroundUrl(this);
        loadBackground(backgroundUrl);
    }

    @Override
    public void loadBackground(final String backgroundUrl) {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                Bitmap backgroundImage = null;
                try {
                    backgroundImage = Picasso.
                            with(BaseActivity.this)
                            .load(backgroundUrl)
                            .get();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Scheduler.Worker inner = AndroidSchedulers.mainThread().createWorker();
                subscriber.add(inner);

                final Bitmap finalBackgroundImage = backgroundImage;
                inner.schedule(new Action0() {
                    @Override
                    public void call() {
                        CoordinatorLayout layout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
                        if (layout != null) {
                            layout.setBackground(new BitmapDrawable(getResources(), finalBackgroundImage));
                        }
                        UserGsemdUtils.saveBackgroundUrl(BaseActivity.this, backgroundUrl);
                    }
                });

            }
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }


    @Override
    public String getDeviceId() {
        final TelephonyManager tm = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
        return deviceUuid.toString();
    }

    public String getTheLastUpdateProductList(){
        Date lastDate = UserGsemdUtils.getLastUpdateDate(AdaliveApplication.getInstance().getApplicationContext());
        return DateUtils.dateToString(lastDate, "yyyy-MM-dd 00:00:00");
    }

    public String getActualTimestamp() {
        DateFormat df = new SimpleDateFormat(kUPDATE_TIME_FORMAT);
        Date today = Calendar.getInstance().getTime();

        return df.format(today);
    }


    public Date convertToDate(String date) {
        DateFormat df = new SimpleDateFormat(kUPDATE_TIME_FORMAT);

        try {
            return df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String retrieveBaseOSParameter(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            return Build.VERSION.BASE_OS;

        return "";
    }

    public static String getSevenDigitsRef(String ref) {
        String newRef = ref;


        for(int i=ref.length(); i < 7; i++) {
            newRef = "0" + newRef;
        }

        return newRef;
    }

    public static String formatPhone(String phone) {
        if (phone != null) {
            if (phone.length() == 10) {
                return "(" + phone.substring(0, 2) + ") " + phone.substring(2, 6) + "-" + phone.substring(6, phone.length());
            }

            if (phone.length() == 11) {
                return "(" + phone.substring(0, 2) + ") " + phone.substring(2, 3) + "-" + phone.substring(3, 7)
                        + "-" + phone.substring(7, phone.length());
            }
        }

        return phone;
    }

    public static String formatCpf(String cpf) {
        if (cpf != null) {
            if (cpf.length() == 11) {
                return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, cpf.length());
            }
        }

        return cpf;
    }
}
*/