const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
    image: {
        type: String,
    },
    email: {
        type: String,
        required: true,
        min: 6
    },
    password: {
        type: String,
        required: true,
        min: 6
    },
    isVerifiedEmail: {
        type: Boolean,
        default: false
    },
    fullName: {
        type: String,
        required: true,
    },
    PANNummber: {
        type: Number,
        validate: {
            validator: function (v) {
                return /^[0-9]{10}/.test(v);
            },
            message: '{VALUE} is not a valid 10 digit number!'
        },
        required: true,
    },
    sex: {
        type: String,
        enum: [Male, Female, Other],
        required: true
    },
    dob: {
        type: Date,
        required: true,
    },
    incomeRange: {
        type: String,
        enum: ["0-1,00,000", "1,00,000-3,00,000", "3,00,000-5,00,000", "5,00,000-above"],
        required: true,
    },
    proffession: {
        type: String,
        enum: ["Student", "Bussiness", "Professional"],
        required: true,
    },
    phoneNumber: {
        type: String,
        required: true,
    },

    created: {
        required: true,
        type: Date,
        default: Date.now()
    },

});

module.exports = mongoose.model('User', userSchema);