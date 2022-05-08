var express = require('express');
var router = express.Router();
const Startup = require('../models/Startup');
const News = require('../models/News');
const Investment = require("../models/Investment");
const User = require("../models/User");
/* GET home page. */
router.get('/', function (req, res, next) {
  res.render('index', { title: 'Investoz' });
});
router.post('/add-startup-data', async function (req, res, next) {
  try {


    const reqStartup = req.body;
    const startupToSave = new Startup({
      logo: reqStartup.logo,
      name: reqStartup.name,
      about: reqStartup.about,
      evaluation: reqStartup.evaluation,
      minAmmount: reqStartup.minAmmount
    });

    const savedStartup = await startupToSave.save();
    res.send({ status: "Success", payload: { startup: savedStartup }, message: "Saved Succesfully" })
  } catch (error) {
    res.status(401).send({ status: "Fail", message: "Error Occurred", error: error });
  }

});

router.get('/get-startup-data', async function (req, res, next) {
  try {


    const startup = await Startup.find()
    console.log(startup);
    res.send({ status: "Success", payload: { startup: startup }, message: "startups feteched Succesfully" })
  } catch (error) {
    res.status(401).send({ status: "Fail", message: "Error Occurred", error: error });
  }

});

router.get('/get-news', async function (req, res, next) {
  try {
    const news = await News.find()
    console.log(news);
    res.send({ status: "Success", payload: { news: news }, message: "startups feteched Succesfully" })
  } catch (error) {
    res.status(401).send({ status: "Fail", message: "Error Occurred", error: error });
  }
});


router.post('/add-news', async function (req, res, next) {
  try {


    const reqNews = req.body;
    const newsToSave = new News({
      image: reqNews.image,
      about: reqNews.about,
    });

    const savedNews = await newsToSave.save();
    res.send({ status: "Success", payload: { news: savedNews }, message: "Saved Succesfully" })
  } catch (error) {
    res.status(401).send({ status: "Fail", message: "Error Occurred", error: error });
  }

});

router.get('/get-investment-data', async function (req, res, next) {
  try {
    const investments = await Investment.find()
    console.log(investments);
    res.send({ status: "Success", payload: { investments: investments }, message: "startups feteched Succesfully" })
  } catch (error) {
    res.status(401).send({ status: "Fail", message: "Error Occurred", error: error });
  }
});


router.post('/make-investment', async function (req, res, next) {
  try {
    const reqInvestment = req.body;
    const investmentToSave = new Investment({
      logo: reqInvestment.logo,
      name: reqInvestment.name,
      about: reqInvestment.about,
      percentageEquity: reqInvestment.percentageEquity,
      investmentOffered: reqInvestment.investmentOffered,
      evaluation: reqInvestment.evaluation,
      percentageReturnOnInvestment: reqInvestment.percentageReturnOnInvestment,
      transactionStatus: reqInvestment.transactionStatus,
      owner: reqInvestment.owner,
    });

    const savedInvestment = await Investment.save();
    res.send({ status: "Success", payload: { news: savedNews }, message: "Saved Succesfully" })
  } catch (error) {
    res.status(401).send({ status: "Fail", message: "Error Occurred", error: error });
  }

});

module.exports = router;
