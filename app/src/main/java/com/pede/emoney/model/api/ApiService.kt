package app.clappingape.com.elevaniamartpos.model.api

import com.pede.emoney.model.api.request.SignInRequestModel
import com.pede.emoney.model.api.request.SignUpRequesModel
import com.pede.emoney.model.api.response.SignInResponseModel
import com.pede.emoney.model.api.response.SignUpResponseModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST


interface ApiService {
    /**
     * USERS
     */

    //Users - Sign Up
    @POST("users")
    fun signUp(@HeaderMap headers: Map<String, String>, @Body signUpRequest: SignUpRequesModel): Observable<SignUpResponseModel>

    //Users - Sign In
    @POST("users/login")
    fun signIn(@HeaderMap headers: Map<String, String>, @Body signInRequest: SignInRequestModel): Observable<SignInResponseModel>

//    //Users - Forgot Pin
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.FORGOT_PIN)
//    abstract fun forgotPin(@Header(ApiConfigs.KEY_AUTHORIZATION) authorization: String, @Body resetPinRequest: ResetPinRequest): Call<ForgotPinResponse>
//
//
//    //Users - OTP Verification
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.OTP_VERIFICATION)
//    abstract fun otpVerification(
//        @Header(ApiConfigs.KEY_AUTHORIZATION) authorization: String, @Header(
//            ApiConfigs.KEY_ACCESS_TOKEN
//        ) accessToken: String, @Body otpVerificationRequest: OTPVerificationRequest
//    ): Call<OTPVerificationResponse>
//
//    //Users - Setup PIN
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.SETUP_PIN)
//    abstract fun setupPin(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body setupPinRequest: SetupPinRequest): Call<SetupPinResponse>
//
//    //Users - Sign Out
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE)
//    @POST(ApiKeys.SIGN_OUT)
//    abstract fun signOut(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<SignOutResponse>
//
//    //Users - User Detail
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.USER_DETAIL)
//    abstract fun userDetail(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<UserDetailResponse>
//
//    //Users - User Detail Mobile
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE)
//    @GET(ApiKeys.USER_DETAIL_MOBILE)
//    abstract fun userDetailMobile(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<UserDetailResponse>
//
//    //Users - Edit Profile
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @PATCH(ApiKeys.EDIT_PROFILE)
//    abstract fun editProfile(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body editProfileRequest: EditProfileRequest): Call<EditProfileResponse>
//
//    //Users - Change PIN
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @PUT(ApiKeys.SETUP_PIN)
//    abstract fun changePin(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body changePinRequest: ChangePinRequest): Call<ChangePinResponse>
//
//    //Users - Pin Verification
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.PIN_VERIFICATION)
//    abstract fun pinVerification(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body pinVerificationRequest: PinVerificationRequest): Call<PinVerificationResponse>
//
//    //Transaction - History
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.TRANSACTION_HISTORY)
//    abstract fun transactionHistory(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<TransactionHistoryResponse>
//
//    //Activity - History
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.ACTIVITY_HISTORY)
//    abstract fun activityHistory(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<ActivityHistoryResponse>
//
//    //Get Civil Registry
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.GET_CIVIL_REGISTRY)
//    abstract fun getCivilRegistry(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<GetCivilRegistryResponse>
//
//    //Upload Civil Registry
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.UPLOAD_CIVIL_REGISTRY)
//    abstract fun uploadCivilRegistry(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body civilRegistryRequest: CivilRegistryRequest): Call<CivilRegistryResponse>
//
//
//    /**
//     * Bill Payment
//     */
//
//    //Bill Payment Inquiry
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.TELCO_INQUIRY)
//    abstract fun billPaymentInquiry(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body bIllerPaymentInquiryRequest: BillPaymentInquiryRequest): Call<BillPaymentInquiryResponse>
//
//    //Bill Payment Confirmation
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.TELCO_CONFIRMATION)
//    abstract fun billPaymentConfirmation(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body billerPaymentConfirmationRequest: BillPaymentConfirmationRequest): Call<BillPaymentConfirmationResponse>
//
//
//    /**
//     * QR Payment
//     */
//
//    //QR OFFLINE Inquiry
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.QR_INQUIRY)
//    abstract fun qrOfflineInquiry(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body qrOfflineInquiryRequest: QROfflineInquiryRequest): Call<QRInquiryResponse>
//
//    //QR Offline Inquiry Indomaret
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.QR_INQUIRY)
//    abstract fun indomaretInquiry(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body indomaretInquiryRequest: IndomaretInquiryRequest): Call<IndomaretInquiryResponse>
//
//    //Telco Confirmation
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.TELCO_CONFIRMATION)
//    abstract fun indomaretConfirmation(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body indomaretConfirmationRequest: IndomaretConfirmationRequest): Call<IndomaretConfirmationResponse>
//
//    //QR Offline Cancel Indomaret
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.QR_INQUIRY_CANCEL_INDOMARET)
//    abstract fun indomaretCancel(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body indomaretCancelRequest: IndomaretCancelRequest): Call<IndomaretCancelResponse>
//
//    /**
//     * Telco
//     */
//
//    //Telco Denom
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE_APP_FORM_URLENCODED)
//    @FormUrlEncoded
//    @POST(ApiKeys.TELCO_DENOM)
//    abstract fun telcoDenom(@FieldMap params: Map<String, String>): Call<List<TelcoDenomResponse>>
//
//    //Telco Inquiry
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.TELCO_INQUIRY)
//    abstract fun telcoInquiry(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body telcoInquiryRequest: TelcoInquiryRequest): Call<TelcoInquiryResponse>
//
//    //Telco Confirmation
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.TELCO_CONFIRMATION)
//    abstract fun telcoConfirmation(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body telcoConfirmationRequest: TelcoConfirmationRequest): Call<TelcoConfirmationResponse>
//
//
//    /**
//     * Listrik Air
//     */
//
//    //PLN Prepaid Denom
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE_APP_FORM_URLENCODED)
//    @FormUrlEncoded
//    @POST(ApiKeys.PLN_PREPAID_DENOM)
//    abstract fun plnPrepaidDenom(@FieldMap params: Map<String, String>): Call<List<TelcoDenomResponse>>
//
//    //Listrik Air Inquiry
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.TELCO_INQUIRY)
//    abstract fun listrikAirInquiry(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body listrikAirInquiryRequest: ListrikAirInquiryRequest): Call<ListrikAirInquiryResponse>
//
//    //Listrik Air Confirmation
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.TELCO_CONFIRMATION)
//    abstract fun listrikAirConfirmation(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body listrikAirConfirmationRequest: ListrikAirConfirmationRequest): Call<ListrikAirConfirmationResponse>
//
//
//    /**
//     * PFM
//     */
//
//    //PFM Update Initial Scores
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.PFM_INITIAL_SCORE)
//    abstract fun updatePFMInitialScore(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body pfmUpdateInitialScoreRequest: PFMInitialScoreRequest): Call<PFMScoreResponse>
//
//    //PFM Scores
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.PFM_SCORE)
//    abstract fun getPFMScores(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<PFMScoreResponse>
//
//
//    /**
//     * CMS
//     */
//
//    //CMS Check App Version
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.CMS_CHECK_APP_VERSION)
//    abstract fun checkAppVersion(): Call<CheckVersionResponse>
//
//
//    /**
//     * INVESTMENTS
//     */
//    //Investment Update Balance
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.INVESTMENT_UPDATE_BALANCE)
//    abstract fun updateExtraIncome(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body phlPindahkanSaldoRequest: PHLPindahSaldoRequest): Call<PHLPindahSaldoResponse>
//
//    //Investment PHL History
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.INVESTMENT_PHL_SUMMARY)
//    abstract fun getPHLSummary(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<PHLSummaryResponse>
//
//    //Investment PHL History
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.INVESTMENT_PHL_HISTORY)
//    abstract fun getPHLHistory(
//        @Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Query("offset") offset: Int, @Query(
//            "limit"
//        ) limit: Int
//    ): Call<PHLHistoryResponse>
//
//    //Investment IUR Registration
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.INVESTMENT_IUR_REGISTRATION)
//    abstract fun iurRegistration(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body iurRegistrationRequest: IURRegistrationRequest): Call<IURRegistrationResponse>
//
//    //Investment IUR Summary
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.INVESTMENT_IUR_SUMMARY)
//    abstract fun getIURSummary(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<IURSummaryResponse>
//
//    //Investment IUR History
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.INVESTMENT_IUR_HISTORY)
//    abstract fun getIURHistory(
//        @Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Query("offset") offset: Int, @Query(
//            "limit"
//        ) limit: Int
//    ): Call<IURHistoryResponse>
//
//    //Investment IUR Sell
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.INVESTMENT_IUR_REDEMPTION)
//    abstract fun iurRedemption(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body iurRegistrationRequest: IURRedemptionRequest): Call<IURRedemptionResponse>
//
//    //Investment IUR Disable Intro
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.INVESTMENT_IUR_DISABLE_INTRO)
//    abstract fun iurDisableIntro(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<IURDisableIntroResponse>
//
//
//    //Investment EmasDigi
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.INVESTEMENT_EMASDIGI)
//    abstract fun requestEmasDigiInvestment(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body iurRegistrationRequest: InvestmentEmasDigiPaymentRequest): Call<InvestmentEmasDigiPaymentResponse>
//
//    @GET(ApiKeys.INVESTEMENT_EMASDIGI_SUMMARY)
//    abstract fun requestEmasDigiSummary(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<InvestmentEmasDigiPaymentResponse>
//
//    /**
//     * Insurance
//     */
//
//    //Insurance Inquiry
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.INSURANCE_INQUIRY)
//    abstract fun insuranceInquiry(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body insuranceInquiryRequest: InsuranceInquiryRequest): Call<InsuranceInquiryResponse>
//
//    //Insurance Inquiry JagaMotor
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.INSURANCE_INQUIRY_JAGAMOTOR)
//    abstract fun insuranceInquiryJagaMotor(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body insuranceInquiryJagaMotorRequest: InsuranceInquiryJagaMotorRequest): Call<InsuranceInquiryResponse>
//
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.INSURANCE_INQUIRY_MUDIK)
//    abstract fun insuranceInquiryMudik(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body request: InsuranceInquiryMudikRequest): Call<InsuranceInquiryResponse>
//
//    @POST
//    abstract fun insuranceInquiryMudik(@Url url: String, @Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body request: InsuranceInquiryMudikRequest): Call<InsuranceInquiryResponse>
//
//    //Insurance Confirmation
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.INSURANCE_CONFIRMATION)
//    abstract fun insurancePayment(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body insurancePaymentConfirmationRequest: InsurancePaymentConfirmationRequest): Call<InsurancePaymentConfirmationResponse>
//
//
//    //List Insurance
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.INSURANCE_LIST)
//    abstract fun getListInsurance(
//        @Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Query(
//            "offset"
//        ) offset: Int, @Query("limit") limit: Int
//    ): Call<InsuranceListResponse>
//
//    //List Insurance  Detail
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.INSURANCE_LIST_DETAIL)
//    abstract fun getListInsuranceDetail(
//        @Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Path(
//            "productId"
//        ) productId: String, @Query("offset") offset: Int, @Query("limit") limit: Int
//    ): Call<InsuranceListDetailResponse>
//
//    @GET
//    abstract fun getKotaByProvinsiJagaMotor(
//        @Url url: String, @Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Query(
//            "PROVINCE_DESC"
//        ) PROVINCE_DESC: String
//    ): Call<KotaJagaMotor>
//
//    @GET
//    abstract fun getAllProvinsiJagaMotor(@Url url: String, @Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<ProvinsiJagaMotor>
//
//    @GET
//    abstract fun getAllMerekJagaMotor(@Url url: String, @Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<MerekMotor>
//
//    @GET
//    abstract fun getAllCoveredCity(@Url url: String, @Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<List<MudikCityList>>
//
//    /**
//     * Merchant
//     */
//
//    //Nearby Merchant
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.NEARBY_MERCHANT)
//    abstract fun getNearbyMerchant(
//        @Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String,
//        @Query("search") search: String,
//        @Query("explorationType") type: String,
//        @Query("latitude") latitude: Double,
//        @Query("longitude") longitude: Double,
//        @Query("limit") limit: Int,
//        @Query("offset") offset: Int
//    ): Call<NearbyMerchantResponse>
//
//
//    /**
//     * Gift
//     */
//
//    //Gift List
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.GIFT_LIST)
//    abstract fun getGiftList(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String): Call<GiftListResponse>
//
//    //Gift Send
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.GIFT_SEND)
//    abstract fun giftSend(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body giftSendRequest: GiftSendRequest): Call<GiftSendResponse>
//
//    //Gift Update Status
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.GIFT_UPDATE_STATUS)
//    abstract fun giftUpdateStatus(
//        @Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String,
//        @Path("giftId") giftId: String,
//        @Body giftUpdateStatusRequest: GiftUpdateStatusRequest
//    ): Call<GiftUpdateStatusResponse>
//
//    //Gift Detail
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @GET(ApiKeys.GIFT_DETAIL)
//    abstract fun giftDetail(
//        @Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String,
//        @Path("giftId") giftId: String
//    ): Call<GiftDetailResponse>
//
//
//    /**
//     * BPJS
//     */
//
//    //Telco Inquiry
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.TELCO_INQUIRY)
//    abstract fun bpjsInquiry(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body bpjsInquiryRequest: BPJSInquiryRequest): Call<BPJSInquiryResponse>
//
//    //Telco Confirmation
//    @Headers("Content-Type:" + ApiConfigs.CONTENT_TYPE, "partnerCode:" + ApiConfigs.PARTNER_CODE)
//    @POST(ApiKeys.TELCO_CONFIRMATION)
//    abstract fun bpjsConfirmation(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body bpjsConfirmationRequest: BPJSConfirmationRequest): Call<BPJSConfirmationResponse>
//
//    /**
//     * Voucher
//     */
//
//    @POST(ApiKeys.VOUCHER_GAME)
//    abstract fun requestVoucherGameInvestment(@Header(ApiConfigs.KEY_AUTHORIZATION) accessToken: String, @Body voucherGameRequest: VoucherRequest): Call<VoucherGamePaymentResponse>

}