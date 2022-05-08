const mongoose = require('mongoose')
const startupSchema = new mongoose.Schema({
    logo: {
        type: String,
        required: true,

    },
    name: {
        type: String,
        required: true,

    },
    about: {
        type: String,
        required: true,

    },
    evaluation: {
        type: String,
        required: true,

    },
    minAmmount: {
        type: String,
        required: true,

    },
    percentageEquity: {
        type: String,
        required: true,
    },
    goingUp: {
        type: Boolean,
        required: true,
    }
})
module.exports = mongoose.model('Startup', startupSchema);