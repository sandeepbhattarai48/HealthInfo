package com.example.healthinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

public class HospitalLists extends AppCompatActivity {




    private static final String TAG = "HospitalLists";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mAbout = new ArrayList<>();
    private ArrayList<String> mLocation = new ArrayList<>();
    private ArrayList<String> mPhoneno = new ArrayList<>();
    private ArrayList<String> mEmail = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_recycler_view);
        Log.d(TAG, "onCreate: started.");

        getSupportActionBar().setTitle("Hospital Lists");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/hospitals/580c5cfec4f10.jpg&w=900&h=330");
        mNames.add("Alka Hospital");
        mAbout.add("Alka hospital had its footprints in the form of Alka Pharmacy that was established in 2052 BS (1995 AD) with the aim of supplying sufficient and proper quality medicine to the People within its vicinity ." +
                " Within two year ,with god's grace and endless effort of the staff, the management team thought to expand its services resulting the alka poly clinic (2057BS,2000AD)" +
                " along with its pharmacy.Alka Polyclinic continued to serve People in the fields including doctor's consultancy, diagnostic facilities like X-Ray,USG and ECHO etc.  the heart of the lalitpur district.\n" +
                "\n" +
                "Continuous dedication and day night effort gave grant success and this small setup changed to attain the present shape of Alka Hospital in 2062 BS Under the Nepal Government 's license with the great motto 'WE CARE TO CURE'" +
                " for quality Health Care. The excellent rapid and affordable services provided by the hospital with its well equipped technology drags up to be more conscious and responsible.");
        mLocation.add("Jawalakhel, Lalitpur, Nepal");
        mPhoneno.add("01-5555555, 01-5544477, 01-5535147");
        mEmail.add(" http://alkahospital.com");



        mImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/hospitals/5aa87a614783f.jpg&w=900&h=330");
        mNames.add("Bir Hospital");
        mAbout.add("Bir Hospital is the oldest hospital of Nepal. This hospital was established in 1947 BS, under the name of contemporary Prime Minister Bir Shamsher Jung Bahadur Rana. Today it has a proud history of 125 years and the first hospital of Nepal wherethe practice" +
                " of modern medicinecommenced.\n" +
                "\n" +
                "Currently the hospital consists of 535 beds and it provides medical and surgical treatment to all people.Many people from rural areas come here to get free treatment.The facilities available here are nephrologic " +
                "services,disaster response,surgery,burn and plastic surgery and dental department.");
        mLocation.add("Kanti Path, Kathmandu Nepal");
        mPhoneno.add("01-4221988, 01-4221119");
        mEmail.add(" http://inams.org.np");


        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/58316fac7bd57.jpg");
        mNames.add("Patan Hospital");
        mAbout.add("The story of Patan Hospital is a continuation of a story that began in 1956 in the palace called Shanta Bhawan. However, Patan Hospital also marked a beginning of a new era by replacing the old palace in 1982. Today Patan Hospital has " +
                "its own identities among large governmental and non-governmental hospitals in Nepal, known for its compassionate care, the high values and ethos, trusted by people, rich and poor. Though Patan Hospital during its inception was projected and perceived more" +
                " as a district hospital, over the years it has emerged as a major busy acute care city hospital providing both primary care as well as specialty services both to the local urbanites as well to patients coming from diverse geographic areas within Nepal.\n" +
                "\n" +
                "More than 300,000 people come to this hospital every year for healthcare service and treatment. Patan Hospital now has 320 beds which has increased to 450, after the completition of our maternity ward building construction.\n" +
                "\n" +
                "Apart from clinical services, Patan Hospital's community oriented program, health education classes and rural networking have helped thousands of Nepalese to live a safer and healthier lives. ");
        mLocation.add("Lagankhel,Satdobato Road");
        mPhoneno.add("01-5522295");
        mEmail.add("N/A");



        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/581c1d0e04bf1.jpg");
        mNames.add("Teaching Hospital");
        mAbout.add("The Institute of Medicine (IOM) was established in 1972 under Tribhuvan University with the mandate and the responsibility of training all the categories of health manpower needed in the country. Within the first decade of its establishment. it developed a total of " +
                "12 campuses scattered over the country out of which 3 campuses were in Kathmandu and 9 campuses were outside the Kathmandu Valley.");
        mLocation.add("Maharagunj, Bagmati, Kathmandu");
        mPhoneno.add("01-4412404, 01-4412707, 01-4412505");
        mEmail.add(" http://www.teachinghospital.org.np");




        mImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/hospitals/5a801c5278950.jpg&w=900&h=330");
        mNames.add("Grande Hospital");
        mAbout.add("Grande International Hospital, Kathmandu is a multi-specialty hospital that offers preventive and curative healthcare services. It was established with a motive “Care to Cure” in February 2010. It began as an idea of a patient-oriented, socially responsible center, making superior" +
                " quality healthcare services convenient and accessible for the community it serves. It aims to meet all healthcare needs of the nation through unparalleled patient care and wellness programs.");
        mLocation.add("Dhapasi, Kathmandu, Nepal");
        mPhoneno.add("01-5159266, 01-5159267, 9801202550");
        mEmail.add(" http://www.grandehospital.com");



        mImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/hospitals/5b8f83f7093fe.jpg&w=900&h=330");
        mNames.add("Norvic International Hospital");
        mAbout.add("Norvic International Hospital is the 1st private hospital to introduce the Cardiac Catheterization Lab in the country, we offer one of the world’s best Invasive & Non-Invasive Cardiac facilities to the nation. We possess the best equipped Heart Command Center using the best technology available " +
                "" +
                "in all kinds of Cardiology, Cardiac surgery and Neuro-Surgery. Norvic is the first private sector hospital with \"GO-GREEN HEALTHY HOSPITAL\" Certified provides full fledged Pathological and Diagnostic facilities manned by distinguished panel of Consultant Pathologists and Radiologists to provide the country’s best Out Patients and In Patients diagnosis leading to quality medical care");
        mLocation.add("Thapathali, Kathmandu, Nepal");
        mPhoneno.add("01-4258554, 01-4218230");
        mEmail.add(" http://www.norvichospital.com");



        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/580c70a28c2c0.jpg");
        mNames.add("B.P. Koirala Institute of Health Science");
        mAbout.add("B.P. Koirala Institute of Health Sciences (BPKIHS) was established on Jan 18, 1993 and subsequently upgraded as an autonomous Health Sciences University on Oct 28, 1998 with a mandate to work towards developing socially responsible and competent health workforce, providing health care & involving in " +
                "innovative health research. The Institute, located in Eastern Nepal, has extended its continued health services through teaching district concept to Primary Health Care Centers, District Hospitals and Zonal Hospitals in different districts of the region. This University is aptly named after Bisheshwar Prasad Koirala, Nepal's visionary leader in social uplifting," +
                " firm believer of national integration.\n" +
                "\n" +
                "This Institute is envisaged as one of the successful examples of Nepal-India co-operation. The Health Ministers of the two countries signed the Indo-Nepal agreement for establishment of BPKIHS on the Hindu auspicious day of Mahashivaratri (Mar 10, 1994).");
        mLocation.add("Dharan, Nepal");
        mPhoneno.add("025-525555");
        mEmail.add(" http://www.bpkihs.edu");



        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/58314e7984dc4.jpg");
        mNames.add("Shahid Gangalal National Heart Center");
        mAbout.add("Shahid Gangalal National Heart Centre is providing specialist care in the field of cardiology and cardiac surgery. SGNHC is a full fledged hospital which deals with a wide spectrum of cardiac cases. The centre has established as National referral centre of cardiology and cardiac surgery. Best cardiac services with latest technologies are available here. The hospital is also" +
                " attentive to both the curative and preventive aspect of cardiology & cardiac surgery.\n" +
                "\n" +
                "The number of patients visiting to this centre is rapidly increasing. So, recently the hospital has started the facility of paying clinic. This centre is rapidly building up reputation as a hospital dedicated to heart patient.SGNHC is the busiest cardiac centre in the country and is continue to flourish and develop as a model hospital. ");
        mLocation.add("Bansbari, Kathmandu, Nepal");
        mPhoneno.add("01-4371322, 01-4371374, 01-4370622, 01-4370744");
        mEmail.add(" http://www.sgnhc.org.np");



        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/581edda32a369.jpg");
        mNames.add("OM Hospital and Research Pvt. Ltd.");
        mAbout.add("In 1990, Om Hospital & Research Centre (P.) Ltd began its relentless journey by the name, Om Nursing Home in providing world class health care service at affordable  cost. The Hospital consists of  total 150 beds including Suite & Deluxe and the expertise of over 50 accredited medical professionals in a wide range of specialist field thus bringing quality, integrated healthcare to patient.");
        mLocation.add("Chabahil, Kathmandu Nepal");
        mPhoneno.add(" 01-4476225");
        mEmail.add(" http://www.omhospitalnepal.com/");



        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/580de1e23069b.jpeg");
        mNames.add("Kantipur Hospital");
        mAbout.add("The Kantipur Hospital Private Limited was established in 2054 BS. Taking the aim of providing medical treatment to the patient using the latest technologies introduced in the medical field. The hospital is brought into existence with the combined effort and zeal of the prominent doctors, renowned social activist and Kantipur Saving & Credit Co-operative. " +
                "Since the begging of its establishment this hospital has been trying to provide quality healthcare service targeting middle and lower class people as patients. This hospital feels proud to provide cost effective and best service to its beneficiaries. With the hope of extending more quality healthcare now it has been running with 100 beds in its own building located at Tinkune, Koteshwor, Kathmandu." +
                " Now it has consultant service, OPD, surgical ward, Guano, skin and urinary, Bones, ICU, Cancer ward, Dialysis, Post operative wards, We do have 24 hours Pharmacy and ambulance services. Further it provides a privilege to the local people as well. In co-operation with District Health posts the hospital is helping in vaccination for the growing children. \"Prevention is better than cure\" taking this in mind Kantipur " +
                "Hospital is focusing on regular health check up package program. On this package the physical check up is done thoroughly and if patients are found for further test they will be referred to specialists.");
        mLocation.add("Subidhanagar Tinkune , Kathmandu");
        mPhoneno.add(" 01-4461609, 01-4111627");
        mEmail.add("N/A");




        mImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/hospitals/5b6d3d814e76d.jpg&w=900&h=330");
        mNames.add("Venus Hospita Pvt. Ltd.");
        mAbout.add("Venus Hospital, as a multi specialty general hospital is managed by renowned senior doctors & young professionals to promote quality health care to general public at affordable price & quality modern technologies. It offers a full range of preventive, diagnostic, curative, rehabilitative and surgical as well as counseling therapy via In-Patient Department & Out Patient Department (OPD).\n" +
                "\n" +
                "Established with the prime objective of bringing the best health care service possible, Venus Hospital now moves on to expand its services to the more demanding areas of cancer care, cardiology care,  advance care in Gastroenterology.");
        mLocation.add("Mid Baneshwor, Katmandu, Nepal");
        mPhoneno.add("01-4475120, 01-4490255");
        mEmail.add(" https://venushospital.com.np");




        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/5812fb023e566.jpg");
        mNames.add("Sumeru Hospital");
        mAbout.add("According to the survey of 2010 done by human Human Development Index, there were 5 beds available per 1000 people. Thus the government hospitals were having trouble to handle so many patients where as the private hospitals were way expensive for economically poor people.Thus with the aim of making  “The hospital services available for the deprived populous while providing them with quality services and also using modern" +
                " technologies for the treatment of  patients”, Sumeru Hospital was established on 2068 B.S.");
        mLocation.add("Dhapakhel, Lalitpur");
        mPhoneno.add("01-5275333,01-5275088");
        mEmail.add("http://www.sumerugroup.org.np");



        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/582d6b322557a.jpg");
        mNames.add("GreenCity Hospital");
        mAbout.add("Green City Hospital (GCH) is a well equipped multi-speciality hospital located in Basundhara, Kathmandu. It is led by a team of compassionate multi-disciplinary, highly trained doctors, nurses and technicians who can provide the best care to every patient through integrated clinical service and education. Spread across 28,475 sq.ft. of land, the hospital has 100 beds including 12 Intensive care Units (ICU)," +
                " 5 Neonatal Intensive Care Units modular operation theatre and fully automated laboratory.\n" +
                " ");
        mLocation.add("Dhapasi-8, Basundhara ,Kathmandu, Nepal");
        mPhoneno.add("01-4381133, 01-4383169, 01-4352248");
        mEmail.add("http://www.gch.com.np/");


        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/580de83a528cf.jpg");
        mNames.add("Kathmandu Model College");
        mAbout.add("Kathmandu Model Hospital (KMH) was founded in 1993 as an 18 bed community referral hospital. The capacity expanded to 50 beds in 1995 and additional services were added at this time. Since 2003, KMH has been a tertiary care hospital with 125 beds. Despite limited resources, KMH attempts to make state-of-the art technology available to its clients.\n" +
                "\n" +
                "KMH envisions health services not only in a biomedical context but also in a social context. In accordance with the beliefs of phect-NEPAL, KMH firmly believes that health services should empower the sick to fight all types of suffering.\n"

        );
        mLocation.add("Bagbazar, Kathmandu Nepal");
        mPhoneno.add("01-4240806, 01-4250848, 01-4222364");
        mEmail.add("N/A");



        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/580ddfb577cab.JPG");
        mNames.add("Kanti Children's Hospital");
        mAbout.add("Kanti Children's Hospital (Kanti Baal Aspatal) is a pediatric hospital in Maharajgunj, Kathmandu, Nepal. The hospital is administered and regulated by the Kanti Children's Hospital Development Board, an autonomous body under the Ministry of Health, Government of Nepal.\n" +
                "\n" +
                "The hospital treats children from all over the country and other hospitals. It has a capacity of 350 beds. There are 36 pediatricians, 8 pediatric surgeons, 45 medical officers, 84 general nurses, 25 technicians and paramedics and 107 support staff. The hospital also runs a Post Graduate Degree class with accreditation from National Academy of Medical Education and Sciences (NAMS), Nepal.");
        mLocation.add("Maharajgunj, Kathmandu");
        mPhoneno.add("01-4411550, 01-4414798");
        mEmail.add(" http://kantichildrenhospital.gov.np");



        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/5999379d1137b.jpg");
        mNames.add("Chitwan Medical College (CMC)");
        mAbout.add("A 750 beded teaching hospital, popularly known as CMC, has been provided for the students as a place for clinical study and posting only after successful completion of Integrated Basic Medical Science hours. Apart from the students’ involvement, this hospital serves approximately a quarter of a million people a year, from its district and outskirt areas involving the neighboring states of India also," +
                " with much advanced medical services in almost all clinical areas.");
        mLocation.add("Bharatpur-10 Chitwan, Nepal");
        mPhoneno.add("056-592366, 056-532933");
        mEmail.add(" http://www.cmc.edu.np\n");


        mImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/hospitals/5a8cea74a9b7e.png&w=900&h=330");
        mNames.add("B&C Hospital and Research Center Pvt. Ltd.");
        mAbout.add("Located in the bustling town of Birtamode in Jhapa district in Eastern Nepal, B & C Hospital and Research Center Pvt. Ltd. has been established to bring medical services matching global standard within the reach of Nepalis. As a Multispecialty Hospital their commitment is not to turn any patient away. Therefore, they take care of not only minor ailments like fever and flu but also major conditions needing surgeries" +
                " and transplants. At B & C, they are completely dedicated to invest all their Energies and Resources to helping their Patients recover as quickly as possible.");
        mLocation.add("Birtamode-5, Jhapa, Nepal");
        mPhoneno.add(" 023-545777, 023-545566");
        mEmail.add("http://www.bnchospital.edu.np\n");



        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/580c82eb6da6e.jpg");
        mNames.add("Chitwan Hospital Pvt. Ltd.");
        mAbout.add("Chitwan Hospital Pvt. Ltd. (CHPL) was established in2059 B.S. with the visionary leadership of Dr. Vijaya Paudel. Starting with 15 Beds and 18 staffs, now the hospital is running 55 bedded multispecialty services, which includes almost all the medical, surgical and investigation services with more than 100 Staffs of different categories. CHPL has got high-tec Operation Theater, well equipped ICU, latest medical equipment" +
                " of international standards in Pathology, Endoscopy and Ultrasound as well as Deluxe A/C cabin with the expertise of more than 25 accredited medical doctors of different specialties, thus providing quality and integrated health services. CHPL is going to be a 100 bedded state-of-art corporate hospital very soon.");
        mLocation.add("Bharatpur-10,Chaubiskothi Chitwan, Nepal");
        mPhoneno.add(" 056-527101, 056-527672, 056-522202\n");
        mEmail.add("http://www.chitwanhospital.com.np");



        mImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/hospitals/5b1cf5b40de09.jpg&w=900&h=330");
        mNames.add("Nobel Medical College Teaching Hospital");
        mAbout.add("Overall Vision, Mission and Goals- To produce Doctors of Tomorrow’s Nepal .The Vision of Nobel Medical College Teaching Hospital (NMCTH) is to provide quality medical education in a holistic way and serve the various communities of Eastern Nepal.\n" +
                "\n" +
                "The Mission of Nobel Medical College Teaching Hospital (NMCTH) is to promote human health while stimulating innovation as education is provided at NMCTH in a dynamic learning environment in order to develop physicians, medical scientists and public health professionals. They are trained to become leaders in their respective fields so that they can contribute effectively to the advancement of the basic and " +
                "clinical sciences in medicine through discovery, research, and publication/communication and provide best care to patients and serve the communities.   \n" +
                "\n" +
                "The Goals of Nobel Medical College Teaching Hospital (NMCTH) is to produce doctors who are compassionate, community oriented, affective towards the serving society, competent in application of good communication skills, medical ethics and professionalism with sound cognitive domain and efficient psychomotor skills.\n" +
                "\n" +
                "Nobel Medical College has been playing an active role to fulfill the government plan \"Health for all\". The management of Nobel Medical College has been a part in the joint effort of the Government and the private sector to achieve the health indicator targets as laid down in the Long Term Health Plan 1997-2017 by HMG-Nepal through services to various communities.");
        mLocation.add("Kanchanbari, Biratnagar – 5, Morang");
        mPhoneno.add(" 021 460736 ,021 461735");
        mEmail.add(" http://www.nobelmedicalcollege.com.np/");



        mImageUrls.add("https://www.hamrodoctor.com/uploads/hospitals/5cb970feb005f.jpg");
        mNames.add("Mechi Eye Hospital");
        mAbout.add("With the help of Dutch donors and organizations, a complete and well-equipped eye hospital opened in 2009. The Mechi Eye hospital is well known for its primary eye care and the “outreach programs”. The eye hospital service extends further than the Mechi zone where 1.25 million people live. The hospital also provides ophthalmic care to the Indian population in the neighbouring Indian states of Sikkim, West Bengal, Assam and Bihar, " +
                "where a total of 201 million people reside.");
        mLocation.add("Birtamod 09, Sainik Mode, Jhapa");
        mPhoneno.add(" 023-540153");
        mEmail.add("https://eyecarefoundation.eu/projects/nepal/mechi-eye-hospital/");





        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view_hospitals);
        HospitalRecyclerViewAdapter adapter = new HospitalRecyclerViewAdapter(this, mNames, mImageUrls, mAbout,mLocation,mPhoneno, mEmail);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
