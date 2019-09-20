package com.example.healthinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GeneralKnowledge extends AppCompatActivity {


    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_knowledge);
        getSupportActionBar().setTitle("Health Information");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);



        listView = (ExpandableListView) findViewById(R.id.expandable_list);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousItem = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if(groupPosition != previousItem )
                    listView.collapseGroup(previousItem );
                previousItem = groupPosition;
            }
        });
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();


        listDataHeader.add("What is BMI?");
        listDataHeader.add("What's a normal heart rate?");
        listDataHeader.add("What are calories??");
        listDataHeader.add("What should my daily intake of calories be?");
        listDataHeader.add("How much sugar is good for me?");
        listDataHeader.add("What is the Glycaemic Index (GI)?");
        listDataHeader.add("Do I need vitamin supplements?");
        listDataHeader.add("Can reheating rice cause food poisoning?");
        listDataHeader.add("Can eating too much black liquorice be bad for you?");
        listDataHeader.add("Can clothes and towels spread germs?");
        listDataHeader.add("Can I get chickenpox more than once?");
        listDataHeader.add("Is pneumonia contagious?");
        listDataHeader.add("What infections can used needles or sharps pass on?");
        listDataHeader.add("What is the risk of infection from someone else's blood?");
        listDataHeader.add("What is blood pressure?");
        listDataHeader.add("Why is smoking addictive?");
        listDataHeader.add("How long does alcohol stay in your blood?");
        listDataHeader.add("Why is my waist size important?");
        listDataHeader.add("Can I go swimming after a piercing?");
        listDataHeader.add("Do I have an anxiety disorder?");
        listDataHeader.add("Am I more at risk if my relatives have cancer?");
        listDataHeader.add("Can I drink alcohol while taking antibiotics?");
        listDataHeader.add("Can I take paracetamol if I'm on antibiotics?");
        listDataHeader.add("Can I take paracetamol and ibuprofen together?");
        listDataHeader.add("Why do medicines have expiry dates?");
        listDataHeader.add("Can I crush medicines before taking them?");
        listDataHeader.add("What do cancer stages and grades mean?");
        listDataHeader.add("Why must some medicines be taken on an empty stomach?");
        listDataHeader.add("Why must some medicines be taken with or after food?");
        listDataHeader.add("How many calories do teenagers need?\n");



        List<String> faqs1 = new ArrayList<>();
        faqs1.add("BMI or Body Mass Index is a method of estimating a person's body fat" +
                "\n" +
                " levels based on a person's weight and height measurement. While the BMI calculation is an " +
                "indirect measurementnit has been found to be a fairly reliable indicator of body fat measures in most people.\n" +
                "\n" + "The BMI calculation divides an adult's weight in kilograms by their height in metres squared." +
                " For example, A BMI of 25 means 25kg/m2. ");

        List<String> faqs2 = new ArrayList<>();
        faqs2.add("Most adults have a resting heart rate between 60 and 100bpm.\n" +
                "\n" +
                "The fitter you are, the lower your resting heart rate is likely to be. " +
                "For example, athletes may have a resting heart rate of 40 to 60bpm, or lower.");

        List<String> faqs3 = new ArrayList<>();
        faqs3.add("Calories are a measure of how much energy food or drink contains. The amount of energy you need will depend on:\n" +
                "\n" +
                "► Your age – for example, growing children and teenagers may need more energy\n" +
                "\n" +
                "► Your lifestyle – for example, how active you are\n" + "\n" +
                "► Your size – your height and weight can affect how quickly you use energy");


        List<String> faqs4 = new ArrayList<>();
        faqs4.add("Within a healthy, balanced diet, a man needs around 10,500kJ (2,500kcal) a day to maintain his weight." +
                " For a woman, that figure is around 8,400kJ (2,000kcal) a day.\n" +
                "\n" +
                "These values can vary depending on age, metabolism and levels of physical activity, among other things.");

        List<String> faqs5 = new ArrayList<>();
        faqs5.add("As part of a healthy, balanced diet, you should consume fewer foods and drinks that are high in sugars." +
                "\n" +
                " Sugary foods and drinks can cause tooth decay, especially if you have them between meals.");


        List<String> faqs6 = new ArrayList<>();
        faqs6.add("The glycaemic index (GI) is a rating system for foods containing carbohydrates. It shows how quickly each " +
                "food affects your blood sugar (glucose) level when that food is eaten on its own.");


        List<String> faqs7 = new ArrayList<>();
        faqs7.add("Most people don't need to take vitamin supplements and are able to get all the vitamins and minerals they need by eating a healthy, balanced diet.\n" +
                "\n" +
                "Vitamins and minerals are essential nutrients, such as iron, calcium and vitamin C, that your body needs in small amounts to work properly.\n" +
                "\n" +
                "Many people choose to take supplements, but taking too much or taking them for too long could be harmful");


        List<String> faqs8 = new ArrayList<>();
        faqs8.add("Yes, you can get food poisoning from eating reheated rice. It's not the reheating that causes the problem, " +
                "but the way the rice has been stored before it's reheated.");


        List<String> faqs9 = new ArrayList<>();
        faqs9.add("Yes, particularly if you're over 40 and have a history of heart disease or high blood pressure, or both.\n" +
                "\n" +
                "Eating more than 57g (2 ounces) of black liquorice a day for at least 2 weeks could lead to potentially serious health problems," +
                " such as an increase in blood pressure and an irregular heart rhythm (arrhythmia).\n" +
                "\n" +
                "For most people, liquorice found in foods is safe to eat and safe when consumed in large amounts in medicines for short periods of time.");


        List<String> faqs10 = new ArrayList<>();
        faqs10.add("Yes, clothes and towels can spread germs.\n" +
                "\n" +
                "There are 3 main ways that germs are spread by clothes and towels:\n" +
                "\n" +
                "► When towels or bedlinen are used by more than 1 person germs can spread between them\n" + "\n" +
                "► When someone handles dirty laundry they can spread germs onto their hands\n" + "\n" +
                "► When clothes are washed, germs can spread between items in the process of being washed");


        List<String> faqs11 = new ArrayList<>();
        faqs11.add("Yes, it is possible to get chickenpox more than once, but this is extremely rare.\n" +
                "\n" +
                "Most people who have had chickenpox won't get it again because they're immune to it for life.\n" +
                "\n" +
                "However, some people who have had chickenpox will develop a related condition called shingles later on. " +
                "This is caused by the chickenpox virus being reactivated, usually several decades later.\n" +
                "\n" +
                "You can get chickenpox from someone who's got shingles.\n" +
                "\n" +
                "You can't get shingles from someone who's got chickenpox.");


        List<String> faqs12 = new ArrayList<>();
        faqs12.add("Pneumonia is swelling (inflammation) of the tissue in one or both of the lungs. It's usually caused by an infection – " +
                "most commonly, bacteria and viruses, which are both contagious.");


        List<String> faqs13 = new ArrayList<>();
        faqs13.add("Infections that used needles and sharps can pass on to other people include: \n" +
                "\n" +
                "► Hepatitis B \n" +
                "► Hepatitis C \n" +
                "► HIV  ");

        List<String> faqs14 = new ArrayList<>();
        faqs14.add("Some infections can be passed on in blood or in body fluids (such as saliva) that can become mixed with blood. These are known as blood-borne viruses (BBVs).\n" +
                "\n" +
                "The risk of an infection being passed on in this way largely depends on the type of infection and how you come into contact with the infected blood.");

        List<String> faqs15 = new ArrayList<>();
        faqs15.add("Blood pressure is a measure of the force that your heart uses to pump blood around your body.\n" +
                "\n" +
                "Blood pressure is measured in millimetres of mercury (mmHg) and is given as 2 figures:\n" +
                "\n" +
                "systolic pressure – the pressure when your heart pushes blood out\n" +
                "diastolic pressure – the pressure when your heart rests between beats\n" + "\n" +
                "For example, if your blood pressure is \"140 over 90\" or 140/90mmHg, it means you have a systolic pressure of 140mmHg " +
                "and a diastolic pressure of 90mmHg.");

        List<String> faqs16 = new ArrayList<>();
        faqs16.add("Cigarettes contain nicotine, which is highly addictive." +
                "Nicotine alters the balance of 2 chemicals called dopamine and noradrenaline in your brain.\n" +
                "\n" +
                "When nicotine changes the levels of these chemicals, your mood and concentration levels change. Many smokers find this enjoyable.\n" +
                "\n" +
                "The changes happen very quickly. When you inhale the nicotine, it immediately rushes to your brain, where it produces feelings of pleasure and reduces stress and anxiety.\n" +
                "\n" +
                "This is why many smokers enjoy the nicotine rush and become dependent on it.");

        List<String> faqs17 = new ArrayList<>();
        faqs17.add("On average, it takes about 1 hour for your body to break down 1 unit of alcohol. However, this can vary, depending on:\n" +
                "\n" +
                "► Your weight\n" +
                "► Whether you're male or female\n" +
                "► Your age\n" +
                "► How quickly or slowly your body turns food into energy (your metabolism)\n" +
                "► How much food you have eaten\n" +
                "► The type and strength of the alcohol\n" +
                "► Whether you're taking medication and, if so, what type\n" +
                "► It can also take longer if your liver isn't working normally.\n" +
                "\n" +
                 "How much is 1 unit of alcohol?\n" +
                "1 unit of alcohol is equivalent to 10ml or 8g of pure alcohol. There are roughly:\n" +
                "\n" +
                "► 2.1 units in a standard glass (175ml) of average-strength wine (12%)\n" + "\n" +
                "► 3 units in a large glass (250ml) of average-strength wine (12%)\n" + "\n" +
                "► 2 units in a pint of low-strength lager, beer or cider (3.6%)\n" + "\n" +
                "► 3 units in a pint of higher-strength lager, beer or cider (5.2%)\n" + "\n" +
                "► 1 unit in a single measure of spirits (25ml)");

        List<String> faqs18 = new ArrayList<>();
        faqs18.add("Your risk of some health problems is affected by where your body fat is stored, as well as by your weight. " +
                "Carrying too much fat around your middle" +
                " (waist) can increase your risk of developing conditions such as:\n" +
                "\n" +
                "► Heart disease\n" +
                "► Type 2 diabetes\n" +
                "► Cancer");

        List<String> faqs19 = new ArrayList<>();
        faqs19.add("You should avoid swimming for at least 24 hours after having a piercing, and ideally until it has healed properly." +
                " While it's still healing, it's important to keep the piercing dry as there's a risk of infection." +
                "\n" + "\n" +
                "As a general guide, healing times for the most common body piercings can be:\n" +
                "► Ear lobe – 6 to 8 weeks \n" +
                "► Top of the ear – 6 to 8 weeks \n" +
                "► Belly button (navel) – 6 months to 1 year \n" +
                "► Nose – up to 6 months\n" +
                "► Tongue – 2 to 4 weeks"
        );

        List<String> faqs20 = new ArrayList<>();
        faqs20.add("Anxiety is a feeling of unease, worry or fear. Everyone feels anxious at some point in their life, but for some people it can be an ongoing problem.\n" +
                "\n" +
                "A little bit of anxiety can be helpful – for example, feeling anxious before an exam might make you more alert and improve your performance.\n" +
                "\n" +
                "But too much anxiety could make you tired and unable to concentrate." +
                "\n" +
                "Anxiety can have both psychological and physical symptoms." +
                "\n" +"\n" +
                "Psychological symptoms can include:\n" +
                "► Feeling worried or uneasy a lot of the time\n" +
                "► Having difficulty sleeping, which makes you feel tired\n" +
                "► Not being able to concentrate\n" +
                "► Being irritable\n" +
                "► Being extra alert\n" +
                "► Feeling on edge or not being able to relax\n" +
                "► Needing frequent reassurance from other people\n" +
                "► Feeling tearful" +
                "\n" +
                "\n" +
                "Physical symptoms can include:\n" +
                "► A pounding heartbeat\n" +
                "► Breathing faster\n" +
                "► Palpitations (an irregular heartbeat)\n" +
                "► Feeling sick\n" +
                "► Chest pains\n" +
                "► Headaches\n" +
                "► Sweating\n" +
                "► Loss of appetite\n" +
                "► Feeling faint\n" +
                "► Needing the toilet more frequently");

        List<String> faqs21 = new ArrayList<>();
        faqs21.add("Some types of cancer can run in families. For example, your risks of developing certain types of breast cancer, bowel cancer or ovarian cancer are higher if you have close relatives " +
                "who developed the condition.\n" +
                "\n" +
                "This doesn't mean you'll definitely get cancer if some of your close family members have it, but that you may have an increased risk of developing certain cancers compared to other people.\n" +
                "\n" +
                "It's estimated that between 3 and 10 in every 100 cancers are associated with an inherited faulty gene.\n" +
                "\n" +
                "Cancers caused by inherited faulty genes are much less common than those caused by other factors, such as ageing, smoking, being overweight and not exercising regularly," +
                " or not eating a healthy, balanced diet. Most cancers develop as a result of a combination of risk factors, which in some cases can include family history.");

        List<String> faqs22 = new ArrayList<>();
        faqs22.add("It's sensible to avoid drinking alcohol when taking medication or feeling unwell. But it's unlikely that drinking alcohol in moderation will cause problems if you're taking most common antibiotics.\n" +
                "\n" +
                "To reduce the health risks associated with drinking alcohol, men and women are advised not to regularly drink more than 14 units a week.");

        List<String> faqs23 = new ArrayList<>();
        faqs23.add("Paracetamol is one of the safest painkillers and rarely causes side effects. It's safe to use paracetamol at the same time as taking most antibiotics.\n" +
                "\n" +
                "Taking antibiotics at the same time as paracetamol shouldn't cause any problems. Check your medication leaflet and talk to your pharmacist (chemist) or GP if you're worried about a possible interaction.\n" +
                "\n" +
                "But you must make sure that you carefully follow the dosage instructions provided by the manufacturer for both your antibiotics and the paracetamol. If you're still in significant pain after taking paracetamol, contact your GP.");

        List<String> faqs24 = new ArrayList<>();
        faqs24.add("\n" +
                "Yes, if you're 16 or over, it's safe to take paracetamol and ibuprofen together as there are no known harmful interactions between these medicines." +
                "\n" +"\n" +
                "You can take paracetamol and ibuprofen at the same time or spaced apart. Ibuprofen is best taken with food or on a full stomach.");

        List<String> faqs25 = new ArrayList<>();
        faqs25.add("Medicines have expiry dates so you know when to use them by. After the expiry date medicines may not be safe or as effective.\n" +
                "\n" +
                "You should not take medicines after their expiry date. If you've had a medicine for a while, check the expiry date before using it.\n" +
                "\n" +
                "You should also make sure that you've stored the medicine properly, as described on the packaging or leaflet.\n" +
                "\n" +
                "If your medicine looks, tastes or smells different to when you first got it, even if it's within the expiry date, take it to your pharmacist for advice.");


        List<String> faqs26 = new ArrayList<>();
        faqs26.add("You shouldn't chew, crush or break tablets or pills, or open and empty powder out of capsules, unless your GP or another healthcare professional has told you to do so.\n" +
                "\n" +
                "Some tablets, pills and capsules don't work properly or may be harmful if they're crushed or opened.\n" +
                "\n" +
                "They may need to be swallowed whole because:\n" +
                "\n" +
                "► They're designed to release medicine slowly into your body over time and crushing them could cause an overdose\n" +"\n" +
                "► Your stomach acid could stop them working without their special coating\n" +"\n" +
                "► They could be harmful to the lining of your stomach without their special coating\n" +"\n" +
                "► They may taste unpleasant without their special coating\n" +"\n" +
                "► You could get side effects from inhaling powder from crushed medicines\n" +"\n" +
                "If you've been advised by your healthcare professional to crush your medicine, they'll tell you how to do this and how to take the medicine.");


        List<String> faqs27 = new ArrayList<>();
        faqs27.add("The stage of a cancer describes the size of a tumour and how far it has spread from where it originated. The grade describes the appearance of the cancerous cells." +
                "\n" +"\n" +
                "Different types of staging systems are used for different types of cancer. Below is an example of one common method of staging:\n" +"\n" +
                "► Stage 0 – indicates that the cancer is where it started (in situ) and hasn't spread\n" +"\n" +
                "► Stage I – the cancer is small and hasn't spread anywhere else\n" +"\n" +
                "► Stage II – the cancer has grown, but hasn't spread\n" +"\n" +
                "► Stage III – the cancer is larger and may have spread to the surrounding tissues and/or the lymph nodes (part of the lymphatic system) \n" +"\n" +
                "► Stage IV – the cancer has spread from where it started to at least one other body organ; also known as \"secondary\" or \"metastatic\" cancer");


        List<String> faqs28 = new ArrayList<>();
        faqs28.add("Some medicines need to be taken \"before food\" or \"on an empty stomach\". This is because food and some drinks can affect the way these medicines work.\n" +
                "\n" +
                "For example, taking some medicines at the same time as eating may prevent your stomach and intestines absorbing the medicine, making it less effective. \n" +
                "\n" +
                "Alternatively, some foods can interact with your medicine, either by increasing or decreasing the amount of medicine in your blood to potentially dangerous levels, or levels that are too low to be effective.");


        List<String> faqs29 = new ArrayList<>();
        faqs29.add("Some medicines need to be taken with or after food. Here are the 6 main reasons for this." +
                "► To reduce side effects of nausea or vomiting." +
                "► To reduce side effects of stomach irritation, including indigestion, stomach inflammation or ulcers." +
                "► To treat problems such as heartburn, reflux or indigestion." +
                "► To ensure the medicine is not washed away." +
                "► To ensure the medicine is absorbed into the bloodstream properly." +
                "► To help the body process the meal." +
                "\n" +
                "Medicines for diabetes, if taken by mouth, should usually be taken around meal times to reduce blood sugar levels after eating and to avoid a very low blood sugar (hypoglycaemia).\n" +
                "\n" +
                "Enzyme supplements, which can be used to help people with chronic pancreatitis, should also be taken with food to help the body process the meal.");


        List<String> faqs30 = new ArrayList<>();
        faqs30.add("Teenagers need lots of energy and nutrients because they're still growing. The amount of energy that food and drink contains is measured in kilojoules (kJ) and kilocalories (kcal), commonly just referred to as calories.\n" +
                "\n" +
                "A report from 2011 estimated the average energy requirements for children aged 13 to 18 to be:\n" +
                "\n" +
                "Age\tBoys\tGirls\n" +
                "13\t10,100kJ / 2,414kcal\t9,300kJ / 2,223kcal\n" +
                "14\t11,000kJ / 2,629kcal\t9,800kJ / 2,342kcal\n" +
                "15\t11,800kJ / 2,820kcal\t10,000kJ / 2,390kcal\n" +
                "16\t12,400kJ / 2,964kcal\t10,100kJ / 2,414kcal\n" +
                "17\t12,900kJ / 3,083kcal\t10,300kJ / 2,462kcal\n" +
                "18\t13,200kJ / 3,155kcal\t10,300kJ / 2,462kcal\n" +
                "\n" +
                "However, these figures are only a guide. Young people might need more or less energy depending on a number of factors, including how physically active they are.  \n" +
                "\n" +
                "While the amount of energy teenagers need is important, they should also eat a healthy, balanced diet.");

        listHash.put(listDataHeader.get(0), faqs1);
        listHash.put(listDataHeader.get(1), faqs2);
        listHash.put(listDataHeader.get(2), faqs3);
        listHash.put(listDataHeader.get(3), faqs4);
        listHash.put(listDataHeader.get(4), faqs5);
        listHash.put(listDataHeader.get(5), faqs6);
        listHash.put(listDataHeader.get(6), faqs7);
        listHash.put(listDataHeader.get(7), faqs8);
        listHash.put(listDataHeader.get(8), faqs9);
        listHash.put(listDataHeader.get(9), faqs10);
        listHash.put(listDataHeader.get(10), faqs11);
        listHash.put(listDataHeader.get(11), faqs12);
        listHash.put(listDataHeader.get(12), faqs13);
        listHash.put(listDataHeader.get(13), faqs14);
        listHash.put(listDataHeader.get(14), faqs15);
        listHash.put(listDataHeader.get(15), faqs16);
        listHash.put(listDataHeader.get(16), faqs17);
        listHash.put(listDataHeader.get(17), faqs18);
        listHash.put(listDataHeader.get(18), faqs19);
        listHash.put(listDataHeader.get(19), faqs20);
        listHash.put(listDataHeader.get(20), faqs21);
        listHash.put(listDataHeader.get(21), faqs22);
        listHash.put(listDataHeader.get(22), faqs23);
        listHash.put(listDataHeader.get(23), faqs24);
        listHash.put(listDataHeader.get(24), faqs25);
        listHash.put(listDataHeader.get(25), faqs26);
        listHash.put(listDataHeader.get(26), faqs27);
        listHash.put(listDataHeader.get(27), faqs28);
        listHash.put(listDataHeader.get(28), faqs28);
        listHash.put(listDataHeader.get(29), faqs30);



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
