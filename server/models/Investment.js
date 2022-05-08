const mongoose = require('mongoose')
const investmentSchema = new mongoose.Schema({
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
    percentageEquity: {
        type: String,
    },
    investmentOffered: {
        type: String,
    },
    evaluation: {
        type: String,
        required: true,
    },
    percentageReturnOnInvestment: {
        type: String,
    },
    transactionStatus: {
        type: String,
        enum: ["Confirmed", "Pending", "Failed"]
    },
    owner: {
        type: mongoose.Schema.Types.ObjectId, ref: 'User',
    },
    created: {
        required: true,
        type: Date,
        default: Date.now()
    },
})
module.exports = mongoose.model('Investment', investmentSchema);