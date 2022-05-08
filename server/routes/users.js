var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function (req, res, next) {
  res.send({ name: "hackfest", team: "investoz" });
});

module.exports = router;
